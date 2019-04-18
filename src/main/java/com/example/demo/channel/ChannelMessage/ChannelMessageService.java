package com.example.demo.channel.ChannelMessage;

import com.example.demo.channel.ChannelRepository;
import com.example.demo.message.Message;
import com.example.demo.message.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelMessageService {
    private MessageRepository messageRepository;
    private ChannelRepository channelRepository;

    @Autowired
    public ChannelMessageService(MessageRepository messageRepository, ChannelRepository channelRepository) {
        this.messageRepository = messageRepository;
        this.channelRepository = channelRepository;
    }

    public List<Message> findAllMessagesInChannel(Long channelId) {
        return messageRepository.findByChannel(channelRepository.findById(channelId).get());
    }
}
