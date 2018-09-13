package cn.blsq777.base.controller;

import cn.blsq777.base.bean.User;
import cn.blsq777.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

@Controller
@RequestMapping("/page")
public class PageController
{
    /**
     * 获取log4j对象
     */
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request,HttpServletResponse response,User user,String userName,String passWord){
        ModelAndView mv =new ModelAndView();
        if(userName!=null&&userName!=""){
            User us=userService.getUserByName(userName);
            if(us!=null&&us.getUserName()!=""){
                if(passWord.equals(us.getPassWord())){
                   // mv.addObject("status","success");
                    mv.setViewName("home");

                }else{
                    mv.setViewName("login");
                }
            }
        }else{
            mv.setViewName("login");

        }
        return mv;
    }
    @RequestMapping("home")
    public ModelAndView home(HttpServletRequest request,HttpServletResponse response,User user,String userName,String passWord){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("home");
        return mv;
    }
    /**
     * 功能模块跳转{选择页面}
     * @return
     */
    @RequestMapping("/{type}/{model}/{page}")
    public ModelAndView goPage(HttpServletRequest request,HttpServletResponse response,
            @PathVariable("type") String type,
            @PathVariable("model") String model,
            @PathVariable("page") String page) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("page/" + type + "/" + model + "/" + page);
        return mav;
    }
    /**
     * 功能模块跳转{选择页面}
     * @return
     */
    @RequestMapping("/{type}/{model}/{page}/{tag}")
    public ModelAndView goTag(HttpServletRequest request,HttpServletResponse response,
            @PathVariable("type") String type,
            @PathVariable("model") String model,
            @PathVariable("page") String page,
            @PathVariable("tag") String tag) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("page/" + type + "/" + model + "/" + page + "/" + tag);
        return mav;
    }
}
