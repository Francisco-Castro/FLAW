package com.example.demo.Decorator;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
// TODO
@Repository
public interface DecoratorRepository extends CrudRepository<Decorator, Long> {
}
