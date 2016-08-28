package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author changhongyuan
 * @date 2016年8月28日11:32:02
 *
 * 配置spring和Junit整合，junit启动时加载springIOC容器
 * spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    //注入Dao依实现类依赖
    @Resource
    private SeckillDao seckillDao;


    @Test
    public void queryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
        /*
        1000元秒杀iphone6
        Seckill{seckillId=1000, name='1000元秒杀iphone6', number=100, startTime=Sat Aug 27 00:00:00 CST 2016,
         endTime=Sun Aug 28 00:00:00 CST 2016, createTime=Sat Aug 27 22:43:54 CST 2016}
         */

    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckillList = seckillDao.queryAll(0,100);
        for(Seckill seckill:seckillList){
            System.out.println(seckill);
        }
        /*
        Seckill{seckillId=1000, name='1000元秒杀iphone6', number=100, startTime=Sat Aug 27 00:00:00 CST 2016, endTime=Sun Aug 28 00:00:00 CST 2016, createTime=Sat Aug 27 22:43:54 CST 2016}
        Seckill{seckillId=1001, name='500元秒杀iad2', number=200, startTime=Sat Aug 27 00:00:00 CST 2016, endTime=Sun Aug 28 00:00:00 CST 2016, createTime=Sat Aug 27 22:43:54 CST 2016}
        Seckill{seckillId=1002, name='300元秒杀小米5', number=300, startTime=Sat Aug 27 00:00:00 CST 2016, endTime=Sun Aug 28 00:00:00 CST 2016, createTime=Sat Aug 27 22:43:54 CST 2016}
        Seckill{seckillId=1003, name='100元秒杀红米note', number=400, startTime=Sat Aug 27 00:00:00 CST 2016, endTime=Sun Aug 28 00:00:00 CST 2016, createTime=Sat Aug 27 22:43:54 CST 2016}
         */
    }

    @Test
    public void reduceNumber() throws Exception {
        int updateCount = seckillDao.reduceNumber(1000l,new Date());
        System.out.println(updateCount);
    }
}