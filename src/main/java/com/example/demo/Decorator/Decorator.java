package com.example.demo.Decorator;

import com.example.demo.message.messageBody.MessageBody;

import javax.persistence.*;

@Entity
public abstract class Decorator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private MessageBody messageBody;

    protected abstract String giveMessage();

    public MessageBody getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(MessageBody messageBody) {
        this.messageBody = messageBody;
    }
}
