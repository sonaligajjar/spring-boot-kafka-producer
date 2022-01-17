package com.techprimers.kafka.springbootkafkaproducerexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name")
    private String name;

    @Column(name ="dept")
    private String dept;

    @Column(name ="salary")
    private Long salary;


    public User(String name, String dept, Long salary) {
        this.name=name;
        this.dept=dept;
        this.salary=salary;
    }
}
