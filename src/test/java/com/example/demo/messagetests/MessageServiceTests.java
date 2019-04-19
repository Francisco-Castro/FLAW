package com.example.demo.messagetests;

import com.example.demo.channel.Channel;
import com.example.demo.channel.ChannelRepository;
import com.example.demo.message.Message;
import com.example.demo.message.MessageRepository;
import com.example.demo.message.MessageService;
import com.example.demo.user.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class MessageServiceTests {

    private MessageService messageService;
    private MessageRepository messageRepository = Mockito.mock(MessageRepository.class);
    private ChannelRepository channelRepository = Mockito.mock(ChannelRepository.class);

    @Before
    public void setUp(){
        messageService = new MessageService(messageRepository, channelRepository);
    }

    @Test
    public void indexTest(){
        Message message1 = new Message("this is my message1", new User(), new Channel());
        Message message2 = new Message("this is my message2", new User(), new Channel());
        Message message3 = new Message("this is my message3", new User(), new Channel());
        List<Message> messages = new ArrayList<>();
        messages.add(message1);
        messages.add(message2);
        messages.add(message3);
        when(messageRepository.findAll()).thenReturn(messages);
        // When
        Iterable<Message> actual = messageService.index();
        // Then
        Assert.assertEquals(messages, actual);
    }

    @Test
    public void showTest(){
        // Given
        Message message = new Message("this is my message", new User(), new Channel());
        when(messageRepository.findById(1L)).thenReturn(Optional.of(message));
        // When
        Message actual = messageService.show(1L);
        // Then
        Assert.assertEquals(message, actual);
    }

    @Test
    public void createTest(){
        // Given
        Message message = new Message("this is my message", new User(), new Channel());
        when(messageRepository.save(message)).thenReturn(message);
        // When
        Message actual = messageService.create(message);
        // Then
        Assert.assertEquals(message, actual);
    }

    @Test
    public void updateTest() {
        // Given
        Message original = new Message("this is my message", new User(), new Channel());
        Message newMessage = new Message("New message body", new User(), new Channel());
        when(messageRepository.findById(original.getId())).thenReturn(Optional.of(original));
        when(messageRepository.save(original)).thenReturn(newMessage);
        // When
        Message actual = messageService.update(original.getId(), newMessage);
        newMessage.setId(original.getId());
        // Then
        Assert.assertEquals(newMessage, actual);
    }

    @After
    public void tearDown() {
        messageService = null;
    }
}
