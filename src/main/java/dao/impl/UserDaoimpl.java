package dao.impl;

import dao.IUserDao;
import entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by Starry on 2017/12/11.
 */
@Repository("userDao")
public class UserDaoimpl extends BaseDaoimpl<UserEntity,Long> implements IUserDao{
    @Override
    public UserEntity queryById(long id) {
        return super.get(id);
    }
}