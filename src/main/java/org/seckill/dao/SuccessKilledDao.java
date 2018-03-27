package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {

	/**
	 * 
	 * @param seckillId
	 * @param userPhone
	 * @return 
	 */
	int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
	
	/**
	 * 
	 * @param seckillId
	 * @return 
	 */
	SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
	
	
	

}
