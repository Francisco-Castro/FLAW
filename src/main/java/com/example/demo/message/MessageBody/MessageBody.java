package com.example.demo.message.MessageBody;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class MessageBody {

    @OneToMany
    private List<Decorator> decorators;

    public MessageBody(List<Decorator> decorators) {
        this.decorators = decorators;
    }
}
