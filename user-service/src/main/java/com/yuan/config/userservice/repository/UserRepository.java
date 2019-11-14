package com.yuan.config.userservice.repository;

import com.yuan.config.userservice.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
//    public User findOne(String id);
    public List<User> findByCompanyId(String companyId);
}
