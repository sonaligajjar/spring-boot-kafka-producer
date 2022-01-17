package com.techprimers.kafka.springbootkafkaproducerexample.service.Impl;

import com.techprimers.kafka.springbootkafkaproducerexample.Repository.UserRepository;
import com.techprimers.kafka.springbootkafkaproducerexample.model.User;
import com.techprimers.kafka.springbootkafkaproducerexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String save(User u) {
        User user= userRepository.save(u);
        return user.toString();
    }
}
