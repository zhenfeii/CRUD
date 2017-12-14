package com.wyu.ui.controller;

import com.wyu.ui.entity.Menu;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
@RestController
public class ShituController {

    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("movie/index");
    }

    /**
     * 获取后台管理主页面
     * @return
     */
    @GetMapping("/admins")
    public ModelAndView listUsers(Model model){
        ModelAndView modelAndView = new ModelAndView("/admins/index");
        List<Menu> list = new ArrayList<>();
        list.add(new Menu("用户管理","/users"));
        list.add(new Menu("角色管理","/roles"));
        list.add(new Menu("任务管理","/tasks"));
        model.addAttribute("list",list);
        return  modelAndView;
    }

}
