package controller;

import dao.IAssociationDao;
import entity.AssociationEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Starry on 2017/12/25.
 */
@Controller
public class AssociationController {
    @Resource(name = "associationDao")
    IAssociationDao associationDao;
    //获取全部社团
    @RequestMapping("/getAssociations")
    public void getAssociations(HttpServletResponse response) throws IOException {
        List<AssociationEntity> list = associationDao.getAll();
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println("获取所有社团："+ jsonArray );
        response.getWriter().print(jsonArray);

    }
    //由校区获取社团
    @RequestMapping("/getAssociationsByCollege/{college}")
    public void getAssociationsByCollege(@PathVariable int college,HttpServletResponse response) throws IOException {
        List<AssociationEntity> list = associationDao.getByCollege(college);
        JSONArray jsonArray = JSONArray.fromObject(list);
        response.getWriter().print(jsonArray);
    }
    @RequestMapping("/getAssociationsByType/{type}")
    public void getAssociationsByType(@PathVariable int type,HttpServletResponse response) throws IOException {
        List<AssociationEntity> list = associationDao.getByType(type+"");
        JSONArray jsonArray = JSONArray.fromObject(list);
        response.getWriter().print(jsonArray);
    }
    @RequestMapping("/getAssociationsByTypeCollege/{type}/{college}")
    public void getAssociationsByTypeCollege(@PathVariable int type ,@PathVariable int college,HttpServletResponse response) throws IOException {
        List<AssociationEntity> list = associationDao.getByTypeAndCollege(type+"",college);
        JSONArray jsonArray = JSONArray.fromObject(list);
        response.getWriter().print(jsonArray);
    }
    @RequestMapping("/searchAssociationByName/{keyword}")
    public void searchAssociationByName(HttpServletRequest request,HttpServletResponse response,@PathVariable String keyword) throws IOException {
        List<AssociationEntity> list = associationDao.searchByName(keyword);
        JSONArray jsonArray = JSONArray.fromObject(list);
        response.getWriter().print(jsonArray);
    }
    @RequestMapping("/getAssociationById/{id}")
    public void getAssociationById(@PathVariable long id,HttpServletResponse response) throws IOException {
        AssociationEntity associationEntity= associationDao.searchById(id);
        JSONObject jsonObject = JSONObject.fromObject(associationEntity);
        response.getWriter().print(jsonObject);
    }
    @RequestMapping("/getAssociationByName/{name}")
    public void getAssociationByName(@PathVariable String name,HttpServletResponse response) throws IOException {
        AssociationEntity associationEntity= associationDao.getByName(name);
        JSONObject jsonObject = JSONObject.fromObject(associationEntity);
        response.getWriter().print(jsonObject);
    }
}
