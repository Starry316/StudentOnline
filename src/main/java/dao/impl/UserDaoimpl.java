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
    public String findUserByName(String username) {
        String hql = "from UserEntity e where e.userName = ?";// ？为占位符，用 setParameter(index , value)替换？的值
        Query query=this.getSession().createQuery(hql);
        query.setParameter(0, username);
        List<UserEntity> list = (List<UserEntity>)query.list(); //若list.size()不为0，说明用户名重复
        return null;
    }

    @Override
    public List<UserEntity> list() {        //不知道怎么写
        //return super.list();
        return null;
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
}