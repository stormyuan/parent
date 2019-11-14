package com.yuan.config.userservice.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.yuan.config.userservice.model.User;
import com.yuan.config.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("{id}")
    public User findById(@PathVariable String id){
        return userService.findOne(id);
    }

    @GetMapping("findByCompanyId/{companyId}")
    public List<User> findByCompanyId(@PathVariable String companyId){
        return userService.findByCompanyId(companyId);
    }

    @GetMapping("eureka-instance")
    public String serviceUrl() {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("USER-SERVICE", false);
        return instance.getHomePageUrl();
    }

    @GetMapping("instance-info")
    public String showinfo() {
        List<ServiceInstance> list = discoveryClient.getInstances("USER-SERVICE");
        if (list != null && list.size() > 0 ) {
            return list.get(0).getUri().toString();
        }
        return null;
    }
}
