package com.project.user.service.service;


import com.project.user.service.VO.Department;
import com.project.user.service.VO.ResponseTemplateVO;
import com.project.user.service.entity.Users;
import com.project.user.service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    public Users saveUser(Users user) {
        log.info("Inside getUserWithDepartment ");
        return userRepository.save(user);
    }

     public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment ");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Users user = userRepository.findByUserId(userId);
       //  Department department =  restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(),Department.class);
       Department department =  restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),Department.class);

         vo.setUser(user);
         vo.setDepartment(department);
         return  vo;
    }

}
