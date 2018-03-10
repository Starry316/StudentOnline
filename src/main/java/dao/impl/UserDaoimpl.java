package dao.impl;

import dao.IUserDao;
import entity.UserEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by Starry on 2017/12/11.
 */
@Repository("userDao")
public class UserDaoimpl extends BaseDaoimpl<UserEntity,Long> implements IUserDao{
    @Override
    public UserEntity queryById(long id) {
        return super.get(id);
    }

    @Override
    public Long addUser(UserEntity user) {
        return super.save(user);
    }

    @Override
    public boolean findUserByName(String username) {
        String hql = "from UserEntity e where e.userName = ?";// ？为占位符，用 setParameter(index , value)替换？的值
        Query query=this.getSession().createQuery(hql);
        query.setParameter(0, username);
        List<UserEntity> list = (List<UserEntity>)query.list(); //若list.size()不为0，说明用户名重复
        if(list.size()>0)
            return true;
        else
            return false;
    }


    @Override
    @Transactional
    public void updateInfo(UserEntity user) {
         super.update(user);
    }

    @Override
    public void deleteUserById(long id) {
        super.delete(id);
    }

    @Override
    public boolean userLogin(UserEntity user) {
        String hql = "from UserEntity e where e.userName = ? and e.passWord = ?";
        Query query = this.getSession().createQuery(hql);
        query.setParameter(0,user.getUserName());
        query.setParameter(1,user.getPassWord());
        List<UserEntity> list = (List<UserEntity>)query.list();
        if(list.size()>1)
            return true;
        else
            return false;
    }

    @Override
    public UserEntity get(long id) {
        return super.get(id);
    }
}