package com.mighty.springbootexercise.controller;

import com.mighty.springbootexercise.entity.Result;
import com.mighty.springbootexercise.entity.User;
import com.mighty.springbootexercise.repository.UserRepository;
import com.mighty.springbootexercise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /**
     * 123
     *
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> userList() {
        return userRepository.findAll();
    }

/*       @PostMapping(value = "/user")
    public User addUser(@RequestParam("sex") Integer sex, @RequestParam("name") String name) {
        User user = new User();
        user.setName(name);
        user.setSex(sex);
        return userRepository.save(user);
    }*/

    @PostMapping(value = "/user")
    public Result addUser(@Valid User user, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
//            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            result.setCode(1);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());

            return null;
        }

        result.setCode(0);
        result.setMsg("成功");
        result.setData(userRepository.save(user));
        return result;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User findOne(@PathVariable("id") Integer id) {
        return userRepository.findById(id).get();
    }


    @RequestMapping(value = "/user/sex/{sex}", method = RequestMethod.GET)
    public List<User> findBySex(@PathVariable("sex") Integer sex) {
        return userRepository.findBySex(sex);
    }

    @GetMapping(value = "/users/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        userService.getAge(id);
    }

}
