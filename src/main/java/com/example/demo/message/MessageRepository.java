package com.example.demo.message;

import com.example.demo.channel.Channel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findByChannel(Channel channel);
}
