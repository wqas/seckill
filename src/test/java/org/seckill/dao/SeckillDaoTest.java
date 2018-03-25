package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.seckill.dao.SeckillDao;
import org.seckill.entity.Seckill;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:/D:/Users/Lucie/Workspaces/MyEclipse%202017%20CI/seckill/target/classes/spring/spring-dao.xml"})
public class SeckillDaoTest {
	
	@Autowired
	private SeckillDao seckillDao;
	
	@Test
	public void testQueryId()throws Exception{
		long id = 1000;
		Seckill seckill = seckillDao.queryId(id);
		System.out.println("seckill.getName()" + seckill.getName());
		System.out.println("seckill :" + seckill);
	}
	
	@Test
	public void testQueryAll()throws Exception{
			
	}

	@Test
	public void testReduceNumver() throws Exception {

	}	
	
}
