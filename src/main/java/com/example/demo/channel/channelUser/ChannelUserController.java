package com.example.demo.channel.channelUser;

import com.example.demo.channel.Channel;
import com.example.demo.channel.ChannelService;
import com.example.demo.user.User;
import com.example.demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChannelUserController {

    private ChannelUserService channelUserService;
    private ChannelService channelService;
    private UserService userService;

    @Autowired
    public ChannelUserController(ChannelUserService channelUserService, ChannelService channelService,
                                 UserService userService) {
        this.channelUserService = channelUserService;
        this.channelService = channelService;
        this.userService = userService;
    }

    @GetMapping("/channels/{id}/users")
    public ResponseEntity<Iterable<User>> getAllUsersInChannel(@PathVariable Long id){
        Channel channel = channelService.show(id);

        return new ResponseEntity<>(channelUserService.getAllUsersInChannel(channel), HttpStatus.OK);
    }

    @PostMapping("/channels/{id}/users/{userid}")
    public ResponseEntity<User> addUser (@PathVariable Long id, @PathVariable Long userid){
        Channel channel = channelService.show(id);
        User user = userService.show(userid);

        channelUserService.addUser(channel, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/channels/{id}/users/{userid}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id, @PathVariable Long userid){
        Channel channel = channelService.show(id);
        User user = userService.show(userid);

        channelUserService.deleteUser(channel, user);
        return new ResponseEntity<>(user, HttpStatus.NO_CONTENT);
    }

}
