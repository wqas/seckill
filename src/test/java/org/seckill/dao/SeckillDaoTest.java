package org.seckill.dao;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.seckill.dao.SeckillDao;
import org.seckill.entity.Seckill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-dao.xml" })
public class SeckillDaoTest {
	
	@Resource
	private SeckillDao seckillDao;
	

	@Test
	public void testQueryId() throws Exception {
		
		long id = 1001L;
		Seckill seckill = seckillDao.queryId(id);
		System.out.println("seckill.getName()" + seckill.getName());
		System.out.println("seckill :" + seckill);

	}
	
	@Test
	public void testQueryAll() throws Exception {
	
		List<Seckill> seckills = seckillDao.queryAll(0, 100);
		
		for(Seckill seckill: seckills){
		System.out.println("seckill.getName()" + seckill.getName());
		System.out.println("seckill :" + seckill);
		}
	}

	@Test
	public void testReduceNumver() throws Exception {
		
		Date killTime = new Date();
		System.out.println("killTime:  " + killTime);
		int updateCol = seckillDao.reduceNumver(1000L, killTime);
		System.out.println("updateCol:  " + updateCol);

	}

}
