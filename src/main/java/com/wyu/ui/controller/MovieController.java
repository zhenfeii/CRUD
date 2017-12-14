package com.wyu.ui.controller;

import com.wyu.ui.dao.MovieDao;
import com.wyu.ui.entity.Movie;
import com.wyu.ui.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator  2017/11/28 0028.
 */

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieDao movieDao;

    /**
     *  暂时不用这种方式
     *  restful API
     */
    @GetMapping("/list")
    public ResponseEntity<?> getAll(){
        List<Map<String,Object>> list = movieDao.getAll();
        Response response = new Response("200","",list);
        return new ResponseEntity<Object>(response,HttpStatus.OK);
    }

    /**
     * movie页面
     */
    @GetMapping
    public String movie(ModelMap map){
        map.addAttribute("movielist",movieDao.getAll());
        return "movielist";
    }

    /**
     *   新增movie页面
     */
    @GetMapping("/create")
    public String createForm(ModelMap map){
        map.addAttribute("movie",new Movie());
        map.addAttribute("action","create");
        return "movieForm";
    }

    /**
     *  新增movie
     *  处理表单的post请求
     */
    @PostMapping("/create")
    public String postMoive(@ModelAttribute Movie movie){
        movieDao.insertByMovie(movie);
        return "redirect:/movie";
    }

    /**
     *  删除movie
     *
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String createForm(@PathVariable Long id){
        movieDao.deleteById(id);
        return "redirect:/movie";
    }

    /**
     * 显示需要更新用户表单
     */
    @GetMapping("/update/{id}")
    public String getMovie(@PathVariable Long id, ModelMap map){
        map.addAttribute("movie",movieDao.findById(id));
        map.addAttribute("action","update");
        return "/movieForm";
    }

    /**
     * 更新movie
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@ModelAttribute Movie movie){
        movieDao.update(movie);
        return "redirect:/movie";
    }
}
