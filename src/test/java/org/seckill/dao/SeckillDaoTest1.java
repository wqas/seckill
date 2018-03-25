package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.SeckillDao;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest1 {
	

	//@Autowired(required=false)
	@Autowired(required=false)
	private SeckillDao seckillDao;
	
	
	/**
	 * @throws Exception
	 */
	@Test
	public void testQueryId() throws Exception{
		long id = 1000;
		System.out.println("will output" + id);
		Seckill seckill = seckillDao.queryId(id);
		System.out.println("seckill.getName()" + seckill.getName());
		System.out.println("seckill :" + seckill);
	}

}
