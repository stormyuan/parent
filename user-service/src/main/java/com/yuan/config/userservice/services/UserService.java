package com.yuan.config.userservice.services;

import com.yuan.config.userservice.model.User;
import com.yuan.config.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findOne(String id) {
        User user = new User(id, "1", "user");
        return user;
    }

    public List<User> findByCompanyId(String companyId) {
        return userRepository.findByCompanyId(companyId);
    }
}
