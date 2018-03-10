package test;


import com.alibaba.fastjson.JSON;
import dao.IActivityDao;
import dao.IAssociationDao;
import dao.IUserDao;
import entity.ActivityEntity;
import entity.AssociationEntity;
import entity.UserEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
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
        String s = "[{\"college\":1,\"associationName\":\"associationname1\",\"member\":10,\"id\":1,\"managerId\":1,\"type\":\"2\",\"foundedTime\":{\"date\":23,\"hours\":12,\"seconds\":23,\"month\":1,\"nanos\":0,\"timezoneOffset\":-480,\"year\":118,\"minutes\":51,\"time\":1519361483000,\"day\":5},\"introduction\":\"introduction1\"},{\"college\":2,\"associationName\":\"associationname2\",\"member\":11,\"id\":2,\"managerId\":2,\"type\":\"2\",\"foundedTime\":{\"date\":23,\"hours\":12,\"seconds\":21,\"month\":1,\"nanos\":0,\"timezoneOffset\":-480,\"year\":118,\"minutes\":51,\"time\":1519361481000,\"day\":5},\"introduction\":\"introduction2\"},{\"college\":3,\"associationName\":\"associationname3\",\"member\":12,\"id\":3,\"managerId\":1,\"type\":\"3\",\"foundedTime\":{\"date\":23,\"hours\":12,\"seconds\":38,\"month\":1,\"nanos\":0,\"timezoneOffset\":-480,\"year\":118,\"minutes\":51,\"time\":1519361498000,\"day\":5},\"introduction\":\"introduction2\"}]";
        JSONArray a =JSONArray.fromObject(s);

        ActivityEntity activityEntity =activityDao.getByName("asda");
        System.out.println( activityEntity.getActivityContent());




    }
}