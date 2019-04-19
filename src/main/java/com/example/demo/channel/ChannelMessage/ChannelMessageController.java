package com.example.demo.channel.ChannelMessage;

import com.example.demo.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ChannelMessageController {
    private ChannelMessageService channelMessageService;

    @Autowired
    public ChannelMessageController(ChannelMessageService channelMessageService) {
        this.channelMessageService = channelMessageService;
    }

    @GetMapping("/channel/{channelId}/messages")
    public List<Message> findAllMessagesInChannel(@PathVariable Long channelId) {
        return channelMessageService.findAllMessagesInChannel(channelId);
    }
}
