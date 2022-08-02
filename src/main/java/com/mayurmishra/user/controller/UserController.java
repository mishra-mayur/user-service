package com.mayurmishra.user.controller;

import com.mayurmishra.user.VO.ResponseTemplateVO;
import com.mayurmishra.user.entity.User;
import com.mayurmishra.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project - user-service
 * Created By MAYUR on 01/08/22
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Request received for saving user : {}", user);
       return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUser(@PathVariable("id") Long userId) {
        log.info("Request received for getting user by id : {}", userId);
        ResponseTemplateVO responseTemplateVO =  userService.getUserById(userId);
        return new ResponseTemplateVO(responseTemplateVO.getUser(),responseTemplateVO.getDepartment());
    }
}
