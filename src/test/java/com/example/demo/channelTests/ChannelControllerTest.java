package com.example.demo.channelTests;

import com.example.demo.channel.Channel;
import com.example.demo.channel.ChannelRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ChannelControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ChannelRepository channelRepository;

    @Test
    public void testShow() throws Exception{
        Long givenId = 1L;
        BDDMockito
                .given(channelRepository.findById(givenId))
                .willReturn(Optional.of(new Channel("New Channel", new ArrayList<>(), new ArrayList<>())));
        String expectedContent = "{\"name\":\"New Channel\",\"messages\":[],\"users\":[]}";
        this.mvc.perform(MockMvcRequestBuilders
                .get("/channels/" + givenId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testCreate() throws Exception {
        Channel channel = new Channel("New Channel", new ArrayList<>(), new ArrayList<>());
        BDDMockito
                .given(channelRepository.save(channel))
                .willReturn(channel);

        String expectedContent="{\"name\":\"New Channel\",\"messages\":[],\"users\":[]}";
        this.mvc.perform(MockMvcRequestBuilders
                .post("/channels/")
                .content(expectedContent)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }
}
