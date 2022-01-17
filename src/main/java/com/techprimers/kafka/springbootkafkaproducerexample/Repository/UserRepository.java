package com.techprimers.kafka.springbootkafkaproducerexample.Repository;

import com.techprimers.kafka.springbootkafkaproducerexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
