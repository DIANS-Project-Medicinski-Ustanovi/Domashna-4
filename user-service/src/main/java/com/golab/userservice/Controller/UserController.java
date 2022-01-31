package com.golab.userservice.Controller;

import com.golab.userservice.Model.User;
import com.golab.userservice.Service.UserService;
import com.golab.userservice.VO.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithMedUstanova(@PathVariable("id") Long userId){
        log.info("Inside getUserWithMedUstanova of UserController");
        return userService.getUserWithDepartment(userId);
    }
}

