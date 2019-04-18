package com.example.demo.message;

import com.example.demo.channel.Channel;
import com.example.demo.user.User;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String messageBody;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id")
    private Channel channel;

    public Message() {
    }

    public Message(String messageBody, User user, Channel channel) {
        this.messageBody = messageBody;
        this.user = user;
        this.channel = channel;
    }

    public Long getId() {
        return id;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) &&
                Objects.equals(messageBody, message.messageBody) &&
                Objects.equals(user, message.user) &&
                Objects.equals(channel, message.channel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, messageBody, user, channel);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", messageBody='" + messageBody + '\'' +
                ", user=" + user +
                ", channel=" + channel +
                '}';
    }
}
