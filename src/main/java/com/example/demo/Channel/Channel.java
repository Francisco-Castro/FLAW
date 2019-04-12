package com.example.demo.Channel;

import com.example.demo.message.Message;
import com.example.demo.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    private List<Message> messages;
    @OneToMany
    private List<User> users;

    public Channel(){
        this.name = "";
        this.messages = new ArrayList<>();
        this.users = new ArrayList<>();
    }


    public Channel(String name, List<Message> messages, List<User> users){
        this.name = name;
        this.messages = messages;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
