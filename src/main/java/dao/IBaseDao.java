package dao;

import java.io.Serializable;
import java.util.List;

/**
 * Dao基接口
 * 提供删存查改
 */

public interface IBaseDao<T, K extends Serializable> {

    /**
     * 根据ID获取实体对象.
     * @param id
     * @return 实体对象
     */
    public T get(K id);
    /**
     * 保存实体对象.
     * @param entity
     * @return ID
     */
    public K save(T entity);

    /**
     * 根据实体对象更新.
     * @param t 对象
     */
    public void update(T t);

    /**
     * 根据ID删除记录.
     * @param id
     */
    public void delete(K id);
    /**
     * 获取全部实体对象.
     * @param hql
     * @return
     */
    public List<T> list(String hql, Object[] args);
}