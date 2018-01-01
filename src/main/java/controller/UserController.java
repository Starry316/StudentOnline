package controller;

import dao.IBaseDao;
import dao.IUserDao;
import entity.UserEntity;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.impl.BaseServiceimpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Starry on 2017/12/11.
 */
@Controller
@ContextConfiguration({"classpath:applicationContext.xml"})
@RequestMapping("/user")
public class UserController {
    @Resource(name ="userDao")
    IUserDao userDao;

    @RequestMapping("/get")
    ModelAndView getUser(){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("user",userDao.queryById(1));
        return modelAndView;
    }
    /**添加用户*/
    @RequestMapping("/addUser")
    public String addUser(HttpServletRequest request,HttpServletRequest response){
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        System.out.println(userName);
        System.out.println(passWord);
        UserEntity user = new UserEntity();
        user.setUserName(userName);
        user.setPassWord(passWord);
        userDao.addUser(user);
        return "1";
    }
    /**用户名查重*/
    @RequestMapping("/findUser")
    public @ResponseBody boolean findUserByName(HttpServletRequest request){
        String userName = request.getParameter("username");
        boolean result = userDao.findUserByName(userName);
        return result;
    }

    @RequestMapping("/login")
    public @ResponseBody String  userLogin(String userName,String passWord){
        UserEntity user = new UserEntity();
        //String userName = request.getParameter("username");
        //String passWord = request.getParameter("password");
        user.setUserName(userName);
        user.setPassWord(passWord);
        boolean result = userDao.userLogin(user);
        if(result)
            return "1";
        else
            return "0";
    }
    /*@RequestMapping("/listUsers")
    public String listAll(Map<String,Object> model){
        //Map<String,Object> model 这种形式的返回model中的属性可以任意。
        List<UserEntity> userList =userDao.list();
        model.put("userList", userList);
        return "UsersList";
    }*/


    @RequestMapping("/userUpdate")
    @ResponseBody
    public boolean update(long id, Model model){
        UserEntity user = userDao.queryById(id);
        model.addAttribute(user);
        return true;
    }

    @RequestMapping("/updateInfo")
    @ResponseBody
    public boolean updateInfo(HttpServletRequest request,UserEntity user){
        System.out.println(user.getUserName());
        userDao.updateInfo(user);
        return  true;
    }

    @RequestMapping("/userDelete")
    @ResponseBody
    public boolean delete(long id){
        userDao.deleteUserById(id);return true;
    }


}
