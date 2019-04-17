package com.example.demo.messagetests;

import com.example.demo.channel.Channel;
import com.example.demo.message.Message;
import com.example.demo.message.messageBody.MessageBody;
import com.example.demo.user.User;
import org.junit.Assert;
import org.junit.Test;


public class MessageTest {

//    @Test
//    public void getIdTest() {
//        Message message = new Message();
//        long actual = message.getId();
//        Assert.assertEquals(1L, actual);
//    }

    @Test
    public void getMessageBodyTest() {
        MessageBody messageBody = new MessageBody(null);
        Message message = new Message(messageBody, new User(), new Channel());
        MessageBody actual = message.getMessageBody();
        Assert.assertEquals(messageBody, actual);
    }

    @Test
    public void setMessageBodyTest() {
        MessageBody messageBody = new MessageBody(null);
        Message message = new Message(null, new User(), new Channel());
        message.setMessageBody(messageBody);
        MessageBody actual = message.getMessageBody();
        Assert.assertEquals(messageBody, actual);
    }

    @Test
    public void getUserTest() {
        User user = new User();
        Message message = new Message(null, user, new Channel());
        User actual = message.getUser();
        Assert.assertEquals(user, actual);
    }

    @Test
    public void setUserTest() {
        User user = new User();
        Message message = new Message(null, null, new Channel());
        message.setUser(user);
        User actual = message.getUser();
        Assert.assertEquals(user, actual);
    }
}
