package cn.blsq777.base.controller;

import cn.blsq777.base.bean.User;
import cn.blsq777.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

@Controller
@RequestMapping("/user")
public class UserController
{
    //获取log4j对象
    private Logger logger = Logger.getLogger(this.getClass().getName());
    @Autowired
    private UserService userService;
    @RequestMapping("/index")
    public ModelAndView userIndex(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mv=new ModelAndView();
        User         user =userService.getUserByUserId("1");
       // request.setAttribute("user",user);
        mv.addObject("userName",user.getUserName());
        mv.setViewName("base/test");
        return mv;
    }

}
