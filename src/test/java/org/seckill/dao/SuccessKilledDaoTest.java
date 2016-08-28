package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author changhongyuan
 * @date ${date}
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {
    @Resource
    private SuccessKilledDao successKilledDao;
    @Test
    public void insertSuccessKilled() throws Exception {
        long id = 1000l;
        long phone = 18612964662l;
        int insertCount = successKilledDao.insertSuccessKilled(id,phone);
        System.out.println(insertCount);  //1
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        long id = 1000l;
        long phone = 18612964662l;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id,phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
        /*
        SuccessKilled{seckillId=1000, userPhone=18612964662, state=-1, createTime=Sun Aug 28 14:58:43 CST 2016}
Seckill{seckillId=1000, name='1000元秒杀iphone6', number=100, startTime=Sat Aug 27 00:00:00 CST 2016, endTime=Sun Aug 28 00:00:00 CST 2016, createTime=Sat Aug 27 22:43:54 CST 2016}
         */
    }

}