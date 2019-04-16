package com.example.demo.message;

import com.example.demo.channel.Channel;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

    public Iterable<Message> findByChannel(Channel channel);
}
