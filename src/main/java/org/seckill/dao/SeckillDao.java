package org.seckill.dao;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

public interface SeckillDao {

	/**
	 * @param seckillId
	 * @param killTime
	 * @return
	 */

	int reduceNumver(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

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

	List<Seckill> queryAll(@Param("offet") int offet, @Param("limit") int limit);

}
