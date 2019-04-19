package com.example.demo.channel;

import com.example.demo.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepository extends CrudRepository<Channel, Long> {
    List<User> findAllByChannelId(Channel channel);
}
