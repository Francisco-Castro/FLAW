//package com.example.demo.channelTests;
//
//import com.example.demo.channel.Channel;
//import com.example.demo.channel.ChannelRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.BDDMockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Optional;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@RunWith(SpringRunner.class)
//public class ChannelControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private ChannelRepository channelRepository;
//
//    @Test
//    public void testShow() throws Exception{
//        Long givenId = 1L;
//        BDDMockito
//                .given(channelRepository.findById(givenId))
//                .willReturn(Optional.of(new Channel()));
//    }
//}
