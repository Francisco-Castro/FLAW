package com.example.demo.Decorator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// TODO Check
@Service
public class DecoratorService {

    private DecoratorRepository decoratorRepository;

    @Autowired
    public DecoratorService(DecoratorRepository decoratorRepository) {
        this.decoratorRepository = decoratorRepository;
    }

    public Iterable<Decorator> index() {
        return decoratorRepository.findAll();
    }

    public Decorator show(Long id) {
        return decoratorRepository.findById(id).get();
    }

    public Decorator create(Decorator decorator) {
        return decoratorRepository.save(decorator);
    }

    public Decorator update (Long id, Decorator newDecorator){
        Decorator originalDecorator = decoratorRepository.findById(id).get();
        originalDecorator.setMessageBody(newDecorator.getMessageBody());
        return decoratorRepository.save(originalDecorator);
    }

    public Boolean delete(Long id) {
        decoratorRepository.deleteById(id);
        return true;
    }


}
