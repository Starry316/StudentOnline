package dao.impl;

import dao.IBaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Repository
public class BaseDaoimpl<T, K extends Serializable> implements IBaseDao<T, K>{

    private Class<T> entityClass;
    protected SessionFactory sessionFactory;

    public BaseDaoimpl() {
        this.entityClass = null;
        Class<?> c = getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            this.entityClass = (Class<T>) parameterizedType[0];
        }
    }

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (Exception e) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    public T get(K id) {
        Assert.notNull(id, "id is required");
        return (T) getSession().get(entityClass,id);
    }

    public K save(T entity) {
        Assert.notNull(entity, "entity is required");
        return (K) getSession().save(entity);
    }
    @Override
    public void delete(K id) {
        this.getSession().delete(this.get(id));
    }

    @Override
    public void update(T t) {
        this.getSession().update(t);
    }



    @SuppressWarnings("unchecked")
    @Override
    public List<T> list(String hql, Object[] args) {
        @SuppressWarnings("deprecation")
        Query query=this.getSession().createQuery(hql);
        for (int i = 0; i < args.length; i++) {
            query.setParameter(i, args[i]);
        }
        List<T> list=query.list();
        return list;
    }
}