package com.example.demo.message;

import com.example.demo.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/message/")
    public ResponseEntity<Iterable<Message>> index() {
        return new ResponseEntity<>(messageService.index(), HttpStatus.OK);
    }

    @GetMapping("/message/{id}")
    public ResponseEntity<Message> show(@PathVariable Long id) {
        return new ResponseEntity<>(messageService.show(id), HttpStatus.OK);
    }

    @PostMapping("/message/")
    public ResponseEntity<Message> create(@RequestBody Message message) {
        return new ResponseEntity<>(messageService.create(message), HttpStatus.CREATED);
    }

    @PutMapping("/message/{id}")
    public ResponseEntity<Message> update(@PathVariable Long id, @RequestBody Message message) {
        return new ResponseEntity<>(messageService.update(id, message), HttpStatus.OK);
    }

    @DeleteMapping("/message/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return new ResponseEntity<>(messageService.delete(id), HttpStatus.OK);
    }
}
