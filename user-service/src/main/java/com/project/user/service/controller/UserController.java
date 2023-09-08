package com.project.user.service.controller;

import com.project.user.service.VO.ResponseTemplateVO;
import com.project.user.service.entity.*;
import com.project.user.service.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public Users saveUser(@RequestBody Users user){
        log.info("Inside saveUser");
        return userService.saveUser(user);
    }
    private static final String USER_DEPARTMENT = "getUserWithDepartment";
    @GetMapping("/{id}")
    @CircuitBreaker(name = USER_DEPARTMENT, fallbackMethod = "getUserWithDepartmentFallback")
    public ResponseEntity<ResponseTemplateVO> getUserWithDepartment(@PathVariable("id") Long userId){
       log.info("Inside getUserWithDepartment");
       return new ResponseEntity<ResponseTemplateVO>(userService.getUserWithDepartment(userId), HttpStatus.OK);
    }

   public ResponseEntity<String> getUserWithDepartmentFallback(Exception e){
        ResponseTemplateVO responseTempleVO = new ResponseTemplateVO();
        responseTempleVO.setUser(null);
        responseTempleVO.setDepartment(null);
        return new ResponseEntity<String>("Service is not available. Please try again later",
                HttpStatus.SERVICE_UNAVAILABLE);
    }
}
