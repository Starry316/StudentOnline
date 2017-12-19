package dao;

import entity.UserEntity;
import java.util.List;

/**
 * Created by Starry on 2017/12/11.
 */
public interface IUserDao {
    UserEntity queryById(long id);
    Long addUser(UserEntity user);
    String findUserByName(String username);
    List<UserEntity> list();
    void updateInfo(UserEntity user);
    void deleteUserById(long id);
}
