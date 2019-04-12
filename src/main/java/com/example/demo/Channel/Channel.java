package com.example.demo.Channel;

import javax.persistence.*;
import java.util.List;

@Entity
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //@OneToMany
    //private List<Message> messages;
    //@OneToMany
    //private List<User> users;
}
