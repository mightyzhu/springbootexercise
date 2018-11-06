package com.mighty.springbootexercise.controller;

import com.mighty.springbootexercise.properties.MarkProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * HelloController
 */
//@RestController // RestController =  @Controller + @ResponseBody
@Controller
@ResponseBody
@RequestMapping("/hello")
public class HelloController {

    private final MarkProperties markProperties;

    @Value("${mark.perfect}")
    private int perfect;

    @Autowired
    public HelloController(MarkProperties markProperties) {
        this.markProperties = markProperties;
    }

    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    // 不写method = RequestMethod.GET，默认get，post都可请求
    // @GetMapping(value = "sayHi") 组合注解
    public String say() {
        return markProperties.getGood().toString();
    }

    @RequestMapping(value = {"/say/{id}", "/hi2"}, method = RequestMethod.GET)
    public String say2(@PathVariable("id") int id) { //@PathVariable的使用
        return "id:" + id;
    }

    @RequestMapping(value = {"/say3", "/hi3"}, method = RequestMethod.GET)
    public String say3(@RequestParam(value = "id", required = false, defaultValue = "1") int id) { //@PathVariable的使用
        return "id3:" + id;
    }


}
