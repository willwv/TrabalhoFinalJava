package com.javaee.willwv.TrabalhoFinalJava.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javaee.willwv.TrabalhoFinalJava.domain.Cliente;

@Repository
public interface  ClienteRepository extends MongoRepository <Cliente, String>{

}
