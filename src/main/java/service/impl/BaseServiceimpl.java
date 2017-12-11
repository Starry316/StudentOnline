package service.impl;

import dao.IBaseDao;
import service.IBaseService;

import java.io.Serializable;

/**
 * Created by Starry on 2017/8/1.
 */

public class BaseServiceimpl<T, PK extends Serializable> implements IBaseService<T, PK> {

    private IBaseDao<T, PK> baseDao;

    public IBaseDao<T, PK> getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(IBaseDao<T, PK> baseDao) {
        this.baseDao = baseDao;
    }

    public T get(PK id) {
        return baseDao.get(id);
    }

    public PK save(T entity) {
        return baseDao.save(entity);
    }

}
