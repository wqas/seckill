package org.seckill.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-dao.xml" })
public class SuccessKilledDaoTest {

	@Resource
	SuccessKilledDao successKilledDao;
	
	@Test
	public void testInsertSuccessKilled() throws Exception {
		long seckid = 1002L;
		long userph = 12123459754L;
		int inseCol = successKilledDao.insertSuccessKilled(seckid, userph);
		
		System.out.println("inseCol:  " + inseCol);
		
		
	}
	

	@Test
	public void testQueryByIdWithSeckill() throws Exception {
		
		long seckid = 1002L;
		long userph = 12123459754L;
		SuccessKilled successKilled =successKilledDao.queryByIdWithSeckill(seckid,userph);
		
		System.out.println(successKilled.getSeckill());
		System.out.println(successKilled +""+ successKilled.toString());
		
	}
}
