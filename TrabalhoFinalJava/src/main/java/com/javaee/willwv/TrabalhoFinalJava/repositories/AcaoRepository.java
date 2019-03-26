package com.javaee.willwv.TrabalhoFinalJava.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javaee.willwv.TrabalhoFinalJava.domain.Acao;

@Repository
public interface AcaoRepository extends MongoRepository <Acao, String> {
	
}
