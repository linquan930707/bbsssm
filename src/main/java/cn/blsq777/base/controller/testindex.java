package cn.blsq777.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class testindex
{
    @RequestMapping("/index")
    public ModelAndView indexPage(HttpServletRequest request, HttpServletResponse response,ModelAndView mv){
        mv.setViewName("index");
        return mv;
    }
}
