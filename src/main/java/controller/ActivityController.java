package controller;

import dao.IActivityDao;
import entity.ActivityEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import net.sf.ezmorph.Morpher;
import net.sf.ezmorph.MorpherRegistry;
import net.sf.ezmorph.bean.BeanMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
/**
 * Created by Starry on 2017/12/23.
 */
@Controller
public class ActivityController {
    @Resource(name="activityDao")
    IActivityDao activityDao;

    @RequestMapping("/queryPastActivity")
    public void queryPastActivities(HttpServletResponse response) throws IOException {
        List<ActivityEntity> list =  activityDao.queryPastActivities();
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println( jsonArray );
        response.getWriter().print(jsonArray);
    }

    @RequestMapping("/queryFutureActivity")
    public void queryFutureActivities(HttpServletResponse response) throws IOException {
        List<ActivityEntity> list =  activityDao.queryPastActivities();
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println( jsonArray );
        response.getWriter().print(jsonArray);
    }
    @RequestMapping("/queryActivity")
    public void queryActivity(HttpServletResponse response) throws IOException {
        List<ActivityEntity> list =  activityDao.queryActivities();
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println( jsonArray );
        response.getWriter().print(jsonArray);
    }
    @RequestMapping("/addActivity")
    public void  addActivity(HttpServletRequest request,HttpServletResponse response) throws IOException {
        ActivityEntity activity = new ActivityEntity();
        JSONObject info= JSONObject.fromObject(request.getParameter("info"));
        activity.setActivityName((String)info.get("name"));
        activity.setActivityPlace((String)info.get("place"));
        activity.setActivityContent((String)info.get("content"));
        activity.setActivityStartTime(Timestamp.valueOf((String)info.get("startTime")));
        activity.setActivityEndTime(Timestamp.valueOf((String)info.get("endTime")));
        activity.setAssociationId(Long.parseLong((String)info.get("associationId")));
        Long id = activityDao.addActivity(activity);
        response.getWriter().print(id);
    }

    @RequestMapping("/updateActivityInfo")
    public void updateInfo(HttpServletRequest request){
        ActivityEntity activity = new ActivityEntity();
        JSONObject info= JSONObject.fromObject(request.getParameter("info"));
        activity.setId(Long.parseLong((String)info.get("name")));
        activity.setActivityName((String)info.get("name"));
        activity.setActivityPlace((String)info.get("place"));
        activity.setActivityContent((String)info.get("content"));
        activity.setActivityStartTime(Timestamp.valueOf((String)info.get("startTime")));
        activity.setActivityEndTime(Timestamp.valueOf((String)info.get("endTime")));
        activity.setAssociationId(Long.parseLong((String)info.get("associationId")));
        activityDao.updateInfo(activity);
    }

    @RequestMapping("/deleteActivityEntityById")
    public void deleteActivityEntityById(long id){
        activityDao.deleteActivityEntityById(id);
    }

    @RequestMapping("/searchActivity/{keyword}")
    public void searchActivity(@PathVariable String keyword,HttpServletResponse response) throws IOException {
        List<ActivityEntity> list =  activityDao.search(keyword);
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println( jsonArray );
        response.getWriter().print(jsonArray);
    }
    @RequestMapping("/getActivitiesByAssociationId/{id}")
    public void getActivitiesByAssociationId(@PathVariable long id,HttpServletResponse response) throws IOException {
        List<ActivityEntity> list =  activityDao.getByAssocitionId(id);
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println( jsonArray );
        response.getWriter().print(jsonArray);
    }
    @RequestMapping("/getActivitiesById/{id}")
    public void getActivitiesById(@PathVariable long id,HttpServletResponse response) throws IOException {
        ActivityEntity activityEntity=  activityDao.getById(id);
        JSONObject jsonObject = JSONObject.fromObject(activityEntity);
        response.getWriter().print(jsonObject);
    }
    @RequestMapping("/getActivitiesByName/{name}")
    public void getActivitiesByName(@PathVariable String name,HttpServletResponse response) throws IOException {
        ActivityEntity activityEntity=  activityDao.getByName(name);
        JSONObject jsonObject = JSONObject.fromObject(activityEntity);
        response.getWriter().print(jsonObject);
    }
}
