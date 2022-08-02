package com.mayurmishra.user.service;

import com.mayurmishra.user.VO.Department;
import com.mayurmishra.user.VO.ResponseTemplateVO;
import com.mayurmishra.user.entity.User;
import com.mayurmishra.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Project - user-service
 * Created By MAYUR on 01/08/22
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Calling repository to save user info {}", user);
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserById(Long userId) {
        log.info("Calling repository to get user info {}", userId);
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User user = userRepository.getReferenceById(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + userId, Department.class);
        responseTemplateVO.setUser(new User(user.getUserId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getDepartmentId()));
        responseTemplateVO.setDepartment(department);
        return responseTemplateVO;
    }
}
