package dao.impl;

import dao.IUserDao;
import entity.UserEntity;
import org.springframework.stereotype.Repository;



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
        return null;
    }

    @Override
    public List<UserEntity> list() {        //不知道怎么写
        //return super.list();
        return null;
    }

    @Override
    public void updateInfo(UserEntity user) {
         super.update(user);
    }

    @Override
    public void deleteUserById(long id) {
        super.delete(id);
    }
}