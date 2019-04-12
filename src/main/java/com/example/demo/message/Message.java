package com.example.demo.message;

import com.example.demo.message.MessageBody.MessageBody;
import com.example.demo.user.User;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private MessageBody messageBody;
    @OneToOne
    private User user;

    public Message() {
    }

    public Message(MessageBody messageBody, User user) {
        this.messageBody = messageBody;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public MessageBody getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(MessageBody messageBody) {
        this.messageBody = messageBody;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(messageBody, message.messageBody) &&
                Objects.equals(user, message.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageBody, user);
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageBody=" + messageBody +
                ", user=" + user +
                '}';
    }
}
