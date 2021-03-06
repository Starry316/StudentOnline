package dao.impl;

import dao.IActivityDao;
import entity.ActivityEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Starry on 2017/12/23.
 */
@Repository("activityDao")
public class ActivityDaoimpl extends BaseDaoimpl<ActivityEntity,Long> implements IActivityDao{
    @Override
    public List<ActivityEntity> queryPastActivities() {
        Date time = new java.util.Date();
        Timestamp timestamp = new Timestamp(time.getTime());
        String hql = "from ActivityEntity e where e.activityEndTime < ?";
        Query query=this.getSession().createQuery(hql);
        query.setParameter(0, timestamp);
        List<ActivityEntity> list = (List<ActivityEntity>)query.list();
        return list;
    }

    @Override
    public List<ActivityEntity> queryFutureActivities() {
        Date time = new java.util.Date();
        Timestamp timestamp = new Timestamp(time.getTime());
        String hql = "from ActivityEntity e where e.activityStartTime >= ?";
        Query query=this.getSession().createQuery(hql);
        query.setParameter(0, timestamp);
        List<ActivityEntity> list = (List<ActivityEntity>)query.list();
        return list;
    }

    @Override
    public List<ActivityEntity> queryActivities() {
        Date time = new java.util.Date();
        Timestamp timestamp = new Timestamp(time.getTime());
        String hql = "from ActivityEntity e where e.activityStartTime < ? and e.activityEndTime > ?"; //目前时间在进行的时间范围之中
        Query query=this.getSession().createQuery(hql);
        query.setParameter(0, timestamp);
        query.setParameter(1, timestamp);
        List<ActivityEntity> list = (List<ActivityEntity>)query.list();
        return list;
    }

    @Override
    public Long addActivity(ActivityEntity activityEntity) {
        return super.save(activityEntity);
    }
    @Override
    @Transactional
    public void updateInfo(ActivityEntity activityEntity) {
        super.update(activityEntity);
    }

    @Override
    public void deleteActivityEntityById(long id) {
        super.delete(id);
    }

    @Override
    public List<ActivityEntity> search(String keyword) {
        String hql="from ActivityEntity e where e.activityName like '%"+keyword+"%'";
        Query query=this.getSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<ActivityEntity> getByAssocitionId(long associtionId) {
        String hql="from ActivityEntity e where e.associationId ="+ associtionId;
        Query query=this.getSession().createQuery(hql);
        return query.list();
    }

    @Override
    public ActivityEntity getById(long id) {
        return super.get(id);
    }

    @Override
    public ActivityEntity getByName(String name) {
        String hql="from ActivityEntity e where e.activityName=\'"+name+"\'";
        Query query=this.getSession().createQuery(hql);
        List<ActivityEntity> list = query.list();
        if (list.size()==0)return  null;
        else return list.get(0);
    }
}
