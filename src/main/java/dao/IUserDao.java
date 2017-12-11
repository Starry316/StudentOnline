package dao;

import entity.UserEntity;

/**
 * Created by Starry on 2017/12/11.
 */
public interface IUserDao {
    UserEntity queryById(long id);
}
