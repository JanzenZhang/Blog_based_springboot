package com.janzenzhang.springboot.blog.controller;

import com.janzenzhang.springboot.blog.domain.User;
import com.janzenzhang.springboot.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /*
    查询所有用户
     */
    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList", userRepository.findAll());
        model.addAttribute("title", "用户管理");

        return new ModelAndView("users/list", "userModel", model);
    }
    /*
    根据id查询用户
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model){

        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);

    }
    /*
    获取创建用户form页面
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model){

        model.addAttribute("user", new User(null, null, null));
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);

    }

    /*
    新建用户
     */
    @PostMapping
    public ModelAndView create(User user){
        userRepository.save(user);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, Model model){

        userRepository.delete(id);

        model.addAttribute("userList", userRepository.findAll());
        model.addAttribute("title", "删除用户");
        return new ModelAndView("users/list", "userModel", model);
    }

    @GetMapping("/modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model){

        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");

        return new ModelAndView("users/form", "userModel", model);
    }
}
