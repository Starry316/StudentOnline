package controller;

import dao.IUserDao;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by Starry on 2017/12/11.
 */
@Controller
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserController {
    @Resource(name ="userDao")
    IUserDao userDao;
    @RequestMapping("/get")
    ModelAndView getUser(){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("user",userDao.queryById(1));
        return modelAndView;
    }
}
