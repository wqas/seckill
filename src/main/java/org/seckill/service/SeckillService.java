package org.seckill.service;

import java.util.List;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RerpeaKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

public interface SeckillService {

	/*
	 * 
	 */
	List<Seckill> getSeckillList();

	/*
	 * @param seckillId
	 * 
	 */
	Seckill getById(long seckillId);

	/*
	 * @param seckillId
	 * 
	 */
	Exposer exportSeckillUrl(long seckillId);

	/*
	 * @param seckillId
	 * 
	 * @param userPhone
	 * 
	 * @param md5
	 * 
	 */
	SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws RerpeaKillException, SeckillCloseException, SeckillException;

}