package com.example.demo.message;

import com.example.demo.channel.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private MessageRepository messageRepository;
    private ChannelRepository channelRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, ChannelRepository channelRepository) {
        this.messageRepository = messageRepository;
        this.channelRepository = channelRepository;
    }

    public Iterable<Message> index() {
        return messageRepository.findAll();
    }

    public Message show(Long id) {
        return messageRepository.findById(id).get();
    }

    public Message create(Message message) {
        return messageRepository.save(message);
    }

    public Message update(Long id, Message message) {
        Message original = messageRepository.findById(id).get();
        original.setMessageBody(message.getMessageBody());
        original.setUser(message.getUser());
        return messageRepository.save(original);
    }

    public Boolean delete(Long id) {
        messageRepository.deleteById(id);
        return true;
    }

    public Iterable<Message> findByChannel(Long id) {
        return messageRepository.findByChannel(channelRepository.findById(id).get());
    }
}
