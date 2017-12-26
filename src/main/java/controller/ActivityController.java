package controller;

import dao.IActivityDao;
import entity.ActivityEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;
import net.sf.ezmorph.Morpher;
import net.sf.ezmorph.MorpherRegistry;
import net.sf.ezmorph.bean.BeanMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import util.ObjectToJSON;

/**
 * Created by Starry on 2017/12/23.
 */
@Controller
public class ActivityController {
    @Resource(name="activityDao")
    IActivityDao activityDao;

    ObjectToJSON otj = new ObjectToJSON();

    @RequestMapping("/queryPastActivity")
    public JSONArray queryPastActivities(){
        List<ActivityEntity> list =  activityDao.queryPastActivities();
        JSONArray jsonArray = otj.ListToJSON(list);
        //System.out.println( jsonArray );
        return jsonArray;
    }

    @RequestMapping("/queryFutureActivity")
    public JSONArray queryFutureActivities(){
        List<ActivityEntity> list =  activityDao.queryPastActivities();
        JSONArray jsonArray = otj.ListToJSON(list);
        //System.out.println( jsonArray );
        return jsonArray;
    }

    @RequestMapping("/addActivity")
    public JSONObject  addActivity(String info[]){
        ActivityEntity activity = new ActivityEntity();
        activity.setId(Long.parseLong(info[0]));
        activity.setActivityName(info[1]);
        activity.setActivityPlace(info[2]);
        activity.setActivityContent(info[3]);
        activity.setActivityStartTime(Timestamp.valueOf(info[4]));
        activity.setActivityEndTime(Timestamp.valueOf(info[5]));
        activity.setAssociationId(Long.parseLong(info[6]));
        Long id = activityDao.addActivity(activity);
        JSONObject res = JSONObject.fromObject(id);
        return res;
    }

    @RequestMapping("/updateInfo")
    public void updateInfo(String info[]){
        ActivityEntity activity = new ActivityEntity();
        activity.setId(Long.parseLong(info[0]));
        activity.setActivityName(info[1]);
        activity.setActivityPlace(info[2]);
        activity.setActivityContent(info[3]);
        activity.setActivityStartTime(Timestamp.valueOf(info[4]));
        activity.setActivityEndTime(Timestamp.valueOf(info[5]));
        activity.setAssociationId(Long.parseLong(info[6]));
        activityDao.updateInfo(activity);
    }

    @RequestMapping("/deleteActivityById")
    public void deleteActivityEntityById(long id){
        activityDao.deleteActivityEntityById(id);
    }
}
