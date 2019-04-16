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

    void giveMessage() {

    }

}
