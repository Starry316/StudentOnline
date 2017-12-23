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
        String hql = "from ActivityEntity e where e.activityTime < ?";
        Query query=this.getSession().createQuery(hql);
        query.setParameter(0, timestamp);
        List<ActivityEntity> list = (List<ActivityEntity>)query.list();
        return list;
    }

    @Override
    public List<ActivityEntity> queryFutureActivities() {
        Date time = new java.util.Date();
        Timestamp timestamp = new Timestamp(time.getTime());
        String hql = "from ActivityEntity e where e.activityTime > ?";
        Query query=this.getSession().createQuery(hql);
        query.setParameter(0, timestamp);
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
}
