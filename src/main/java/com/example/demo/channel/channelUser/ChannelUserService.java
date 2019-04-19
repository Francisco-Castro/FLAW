package com.example.demo.channel.channelUser;

import com.example.demo.channel.Channel;
import com.example.demo.channel.ChannelRepository;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelUserService {
    private ChannelRepository channelRepository;
    private UserRepository userRepository;

    @Autowired
    public ChannelUserService(ChannelRepository channelRepository, UserRepository userRepository){
        this.channelRepository = channelRepository;
        this.userRepository = userRepository;
    }

    public Iterable<User> getAllUsersInChannel(Channel channel){
        return channelRepository.findAllByChannelId(channel);
    }

    public Boolean addUser(Channel channel, User user){

        List<User> users = channel.getUsers();

        if (users.contains(user)) {
            return false;
        }

        users.add(user);
        channel.setUsers(users);

        channelRepository.save(channel);

        return true;
    }

    public Boolean deleteUser(Channel channel, User user){
        List<User> users = channel.getUsers();

        if (!users.contains(user)){
            return false;
        }

        users.remove(user);
        channel.setUsers(users);

        channelRepository.save(channel);

        return true;
    }
}
