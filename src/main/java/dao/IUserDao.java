package dao;

import entity.UserEntity;
import java.util.List;

/**
 * Created by Starry on 2017/12/11.
 */
public interface IUserDao {
    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    UserEntity queryById(long id);

    /**
     * 存入新用户
     * @param user
     * @return 新用户id
     */
    Long addUser(UserEntity user);
    String findUserByName(String username);
    List<UserEntity> list();
    void updateInfo(UserEntity user);
    void deleteUserById(long id);
}
