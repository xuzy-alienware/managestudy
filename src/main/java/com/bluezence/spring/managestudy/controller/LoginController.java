package com.bluezence.spring.managestudy.controller;

import com.bluezence.spring.managestudy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
/**
 * RequestMapping
 * value:请求URL的路径，支持URL模板，正则表达式
 * method:HTTP请求方法，有GET、POST、PUT等
 * consumes：允许的媒体类型，如consumes="application/json"，对应于请求的HTTP的Content-Type
 * produces:相应的媒体类型，如produces="application/json"，对应于HTTP请求的Access字段
 * params：参数
 * header：HTTP头的值
 */
/**
 * @valid验证属性
 */
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @InitBinder
    public void bindDateFormat(WebDataBinder binder){
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    @ResponseBody
    @RequestMapping("index")
    public String index(){
        return "1234";
    }

    @RequestMapping("/index1")
    public String index1(){
        return "/hello.btl";
    }

    @RequestMapping(value="/index2/{id}")
    @ResponseBody
    public String getById(@PathVariable("id") int id){
        System.out.println("id=" + id);
        return "id" +id;
    }

    @PostMapping("/index3")
    @ResponseBody
    public String postMapping(){
        return "2345";
    }

    @GetMapping("/index4")
    @ResponseBody
    public String getMapping(){
        return "23456";
    }

    @RequestMapping("/user")
    public String getUserInfo(Model model){
        model.addAttribute("user",loginService.getUser());
        //System.out.println(loginService.getUserCount());
        model.addAttribute("aaa",12344);
        return "/userinfo.html";
    }

    @RequestMapping("/date")
    @ResponseBody
    public void getDate(Date d){
        System.out.println(d);
        return;
    }

    @RequestMapping("/user2")
    public ModelAndView getUserInfo2(){
        ModelAndView view = new ModelAndView();
        view.addObject("user", loginService.getUser());
        view.setViewName("/userinfo");
        return view;
    }

    @RequestMapping("/user3")
    public String getUserInfo3(Model model){
        model.addAttribute("user",loginService.getUserByName("xuzy5"));
        model.addAttribute("aaa",12344);
        return "/userinfo.html";
    }
}
