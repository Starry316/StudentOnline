package test;


import com.alibaba.fastjson.JSON;
import dao.IActivityDao;
import dao.IAssociationDao;
import dao.IUserDao;
import entity.AssociationEntity;
import entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import service.IAssociationService;

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
    @Resource(name = "associationDao")
    IAssociationDao associationDao;
    @Resource(name = "associationService")
    IAssociationService associationService;
    @Resource(name ="activityDao")
    IActivityDao activityDao;
    @Test
    public void TestQuery() {
        System.out.print(userDao.queryById(1).getUserName());
    }
    @Test
    public void TestSave(){
//        AssociationEntity associationEntity =new AssociationEntity();
//        associationEntity.setAssociationName("name");
//        Timestamp timestamp =new Timestamp(new Date().getTime());
//        associationEntity.setFoundedTime(timestamp);
//        associationEntity.setIntroduction("introduction");
//        associationEntity.setManagerId(123);


        System.out.print( associationDao.getByCollege(1).get(0).getAssociationName());
    }
}