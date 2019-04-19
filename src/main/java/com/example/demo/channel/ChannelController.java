package com.example.demo.channel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChannelController {

    private ChannelService channelService;

    @Autowired
    public ChannelController(ChannelService channelService){
        this.channelService = channelService;
    }

    @GetMapping("/channels/")
    public ResponseEntity<Iterable<Channel>> index(){
        return new ResponseEntity<>(channelService.index(), HttpStatus.OK);
    }

    @GetMapping("/channels/{id}")
    public ResponseEntity<Channel> show(@PathVariable Long id){
        return new ResponseEntity<>(channelService.show(id), HttpStatus.OK);
    }

    @PostMapping("/channels/")
    public ResponseEntity<Channel> create(@RequestBody Channel channel){
        return new ResponseEntity<>(channelService.create(channel), HttpStatus.CREATED);
    }

    @PutMapping("/channels/{id}")
    public ResponseEntity<Channel> update(@PathVariable Long id, @RequestBody Channel channel){
        return new ResponseEntity<>(channelService.update(id, channel), HttpStatus.OK);
    }

    @DeleteMapping("/channels/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(channelService.delete(id), HttpStatus.NO_CONTENT);
    }

//    @PutMapping("/channel/{id}/addUser")
//    public ResponseEntity<Channel> addUser(@PathVariable Long id, @RequestBody Long userid){
//        return new ResponseEntity<>(channelService.addUser(id, userid), HttpStatus.OK);
//    }
}

