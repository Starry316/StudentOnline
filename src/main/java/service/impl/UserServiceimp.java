package service.impl;

import entity.UserEntity;
import service.IUserService;

import java.util.List;

/**
 * Created by 11314 on 2017/12/19.
 */
public class UserServiceimp extends BaseServiceimpl<UserEntity,Long> implements IUserService  {
    @Override
    public boolean addUser(UserEntity user) {
        return false;
    }

    @Override
    public UserEntity findUserByName(String userName) {
        return null;
    }

    @Override
    public List<UserEntity> list() {
        return null;
    }

    @Override
    public UserEntity findUserById(long id) {
        return null;
    }

    @Override
    public void updateInfo() {

    }

    @Override
    public void deleteUserById(long id) {

    }
}
