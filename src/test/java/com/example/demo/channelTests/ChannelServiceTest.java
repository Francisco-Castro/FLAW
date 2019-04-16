package com.example.demo.channelTests;

import com.example.demo.DemoApplication;
import com.example.demo.channel.Channel;
import com.example.demo.channel.ChannelController;
import com.example.demo.channel.ChannelService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
public class ChannelServiceTest {

    @MockBean
    private ChannelService channelService;

    private ChannelController channelController;

    @Before
    public void setUp(){
        this.channelController = new ChannelController(channelService);
    }

    @Test
    public void testCreate(){
        // given
        HttpStatus expected = HttpStatus.CREATED;
        Channel expectedChannel = new Channel();
        given(channelService.create(expectedChannel)).willReturn(expectedChannel);

        // when
        ResponseEntity<Channel> response = channelController.create(expectedChannel);
        HttpStatus actual = response.getStatusCode();
        Channel actualChannel = response.getBody();

        // then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedChannel, actualChannel);
    }

    @Test
    public void testShow(){
        // given
        Long channelId = 1L;
        HttpStatus expected = HttpStatus.OK;
        Channel expectedChannel = new Channel();
        given(channelService.show(1L)).willReturn(expectedChannel);

        // when
        ResponseEntity<Channel> response = channelController.show(channelId);
        HttpStatus actual = response.getStatusCode();
        Channel actualChannel = response.getBody();

        // then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedChannel, actualChannel);
    }
}
