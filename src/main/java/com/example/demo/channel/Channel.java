package com.example.demo.channel;

import com.example.demo.message.Message;
import com.example.demo.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "message_id")
    private List<Message> messages;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<User> users;

    public Channel(){
        this.name = "";
        this.messages = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public Channel(String name){
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return Objects.equals(id, channel.id) &&
                Objects.equals(name, channel.name) &&
                Objects.equals(messages, channel.messages) &&
                Objects.equals(users, channel.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, messages, users);
    }

    @Override
    public String toString() {
        return "channel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", messages=" + messages +
                ", users=" + users +
                '}';
    }
}
