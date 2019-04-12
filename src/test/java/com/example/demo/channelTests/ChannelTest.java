package com.example.demo.channelTests;

import com.example.demo.channel.Channel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Entity;

public class ChannelTest {

    @Test
    public void testClassSignatureAnnotations(){
        Assert.assertTrue(Channel.class.isAnnotationPresent(Entity.class));
    }

    @Test
    public void testCreateJson() throws JsonProcessingException {
        ObjectMapper jsonWriter = new ObjectMapper();
        Channel channel = new Channel();
        String json = jsonWriter.writeValueAsString(channel);
    }
}
