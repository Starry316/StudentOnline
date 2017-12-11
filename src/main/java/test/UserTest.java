package test;


import com.alibaba.fastjson.JSON;
import dao.IUserDao;
import entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserTest {

    @Resource(name = "userDao")
    IUserDao userDao;
    @Test
    public void TestQuery() {
        System.out.print(userDao.queryById(1).getUserName());
    }
}