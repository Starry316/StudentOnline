package service;

import entity.UserEntity;

import java.util.List;

/**
 * Created by 11314 on 2017/12/19.
 */
public interface IUserService {
    boolean addUser(UserEntity user);
    UserEntity findUserByName(String userName);
    List<UserEntity> list();
    UserEntity findUserById(long id);
    void updateInfo();
    void deleteUserById(long id);
}
