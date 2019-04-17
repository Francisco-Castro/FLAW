package com.example.demo.Decorator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// TODO Check
@RestController
public class DecoratorController {

    private DecoratorService decoratorService;

    @Autowired
    public DecoratorController(DecoratorService decoratorService) {
        this.decoratorService = decoratorService;
    }

    @GetMapping("/decorator/")
    public ResponseEntity<Iterable<Decorator>> index(){
        return new ResponseEntity<>(decoratorService.index(),HttpStatus.OK);
    }

    @GetMapping("/decorator/{id}")
    public ResponseEntity<Decorator> show(@PathVariable Long id){
        return new ResponseEntity<>(decoratorService.show(id),HttpStatus.OK);
    }

    @PostMapping("/Decorator/")
    public ResponseEntity<Decorator> create(@RequestBody Decorator decorator){
        return new ResponseEntity<>(decoratorService.create(decorator),HttpStatus.CREATED);
    }

    @PutMapping("/decorator/{id}")
    public ResponseEntity<Decorator> update(@PathVariable Long id, @RequestBody Decorator decorator){
        return new ResponseEntity<>(decoratorService.update(id, decorator), HttpStatus.OK);
    }

    @DeleteMapping("/decorator/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(decoratorService.delete(id), HttpStatus.OK);
    }

}
