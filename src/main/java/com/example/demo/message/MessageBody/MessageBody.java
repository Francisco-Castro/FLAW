package com.example.demo.message.MessageBody;

import com.example.demo.Decorator.Decorator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class MessageBody {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "messageBody"
    )
    private List<Decorator> decorators;

    public MessageBody(List<Decorator> decorators) {
        this.decorators = decorators;
    }

    public List<Decorator> getDecorators() {
        return decorators;
    }

    public void setDecorators(List<Decorator> decorators) {
        this.decorators = decorators;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageBody that = (MessageBody) o;
        return Objects.equals(decorators, that.decorators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(decorators);
    }

    @Override
    public String toString() {
        return "MessageBody{" +
                "decorators=" + decorators +
                '}';
    }
}
