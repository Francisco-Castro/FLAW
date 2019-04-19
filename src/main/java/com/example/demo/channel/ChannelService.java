package com.example.demo.channel;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    private ChannelRepository channelRepository;

    @Autowired
    public ChannelService(ChannelRepository channelRepository){
        this.channelRepository = channelRepository;
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
}
