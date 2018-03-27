package org.seckill.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RerpeaKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

@Service
public class SeckillServiceImpl implements SeckillService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SeckillDao seckillDao;
	@Autowired
	private SuccessKilledDao successKilledDao;

	private final String slat = "erhqweitrfhqiwuehf^%$$#%^#987098jkIklsdngf";

	public List<Seckill> getSeckillList() {
		return seckillDao.queryAll(0, 4);
	}

	public Seckill getById(long seckillId) {
		return seckillDao.queryId(1000L);
	}

	public Exposer exportSeckillUrl(long seckillId) {
		Seckill seckill = seckillDao.queryId(seckillId);
		if (seckill == null) {
			return new Exposer(false, seckillId);
		}
		Date startTimeDate = seckill.getStrartTime();
		Date endTimeDate = seckill.getEndTime();
		Date nowDate = new Date();

		if (startTimeDate.getTime() > nowDate.getTime() || endTimeDate.getTime() < nowDate.getTime()) {
			return new Exposer(false, nowDate.getTime(), startTimeDate.getTime(), endTimeDate.getTime());
		}
		String md5 = getMd5(seckillId);
		return new Exposer(true, md5, seckillId);
	}

	/*
	 * ¼ÓÃÜ,²»¿ÉÄæ springframework DigestUtils
	 */
	private String getMd5(long seckillId) {

		String base = seckillId + "/" + slat;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;

	}

	@Transactional
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws RerpeaKillException, SeckillCloseException, SeckillException {

		String md5X = getMd5(seckillId);
		if (md5X == null || !md5.equals(getMd5(seckillId))) {

			throw new SeckillException("yicha");
			// return new SeckillExecution(seckillId, -1, stateInfo);
		}

		try {
			int reduceState = seckillDao.reduceNumver(seckillId, new Date());
			if (reduceState <= 0) {
				throw new SeckillCloseException("CloseException");
			} else {

				int insertState = successKilledDao.insertSuccessKilled(seckillId, userPhone);
				if (insertState <= 0) {
					throw new RerpeaKillException("RerpeaKillException");
				} else {
					SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
					return new SeckillExecution(seckillId,SeckillStatEnum.SUCCESS, successKilled);
				}
			}
		} catch (SeckillCloseException e1) {
			throw e1;
		} catch (RerpeaKillException e2) {
			throw e2;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new SeckillException("SeckillException" + e.getMessage());
		}

	}
}
