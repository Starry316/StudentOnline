package dao;

import entity.ActivityEntity;

import java.util.List;

/**
 * Created by Starry on 2017/12/23.
 */
public interface IActivityDao {
    /**
     * 查询所有未来活动
     * @return 未来活动的list
     */
    List<ActivityEntity> queryFutureActivities();
    /**
     * 查询正在进行的活动
     * @return
     */
    List<ActivityEntity> queryActivities();
    /**
     * 查询所有过去活动
     * @return 过去活动的list
     */
    List<ActivityEntity> queryPastActivities();
    /**
     * 添加新活动
     * @param activityEntity
     * @return 新活动Id
     */
    Long addActivity(ActivityEntity activityEntity);

    /**
     * 更新信息
     * @param activityEntity
     */
    void updateInfo(ActivityEntity activityEntity);

    /**
     * 通过id删除
     * @param id
     */
    void deleteActivityEntityById(long id);

    /**
     * 通过名称查询
     * @param keyword
     * @return
     */
    List<ActivityEntity>search(String keyword);

    /**
     * 通过社团id查询活动
     * @param associtionId
     * @return
     */
    List<ActivityEntity>getByAssocitionId(long associtionId);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    ActivityEntity getById(long id);

    /**
     * 通过名称查询
     * @param name
     * @return
     */
    ActivityEntity getByName(String name);
}
