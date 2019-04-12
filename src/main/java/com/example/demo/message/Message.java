package com.example.demo.message;

import zipcode.group.walf.message.MessageBody.MessageBody;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Message {
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
}
