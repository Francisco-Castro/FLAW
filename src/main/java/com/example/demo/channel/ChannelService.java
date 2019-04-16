package com.example.demo.channel;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    private ChannelRepository channelRepository;
    private UserRepository userRepository;

    @Autowired
    public ChannelService(ChannelRepository channelRepository, UserRepository userRepository){
        this.channelRepository = channelRepository;
        this.userRepository = userRepository;
    }

    public Iterable<Channel> index(){
        return channelRepository.findAll();
    }

    public Channel show(Long id){
        return channelRepository.findById(id).get();
    }

    public Channel create(Channel channel){
        return channelRepository.save(channel);
    }

    public Channel update (Long id, Channel channel){
        Channel original = channelRepository.findById(id).get();
        original.setName(channel.getName());
        original.setMessages(channel.getMessages());
        original.setUsers(channel.getUsers());
        return channelRepository.save(original);
    }

    public Boolean delete (Long id){
        channelRepository.deleteById(id);
        return true;
    }
//
//    public Channel addUser(Long id, Long userid){
//        Channel originalChannel = channelRepository.findById(id).get();
//        User newUser = userRepository.findById(userid).get();
//        List<User> originalUserList = originalChannel.getUsers();
//        originalUserList.add(newUser);
//        originalChannel.setUsers(originalChannel.getUsers());
//        return null;
//    }

}
