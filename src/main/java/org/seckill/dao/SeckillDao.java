package org.seckill.dao;

import java.util.Date;
import java.util.List;

import org.seckill.entity.Seckill;





public interface SeckillDao {

	/**
	 * @param seckillId
	 * @param killTime
	 * @return
	 */

	int reduceNumver(long seckillId, Date killTime);

	/**
	 * @param seckillId
	 */

	Seckill queryId(long seckillId);

	/**
	 * 
	 * @param offet
	 * @param limit
	 * @return
	 */

	List<Seckill> queryAll(int offet, int limit);

}
