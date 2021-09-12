package com.dio.padroes.de.projeto.dio.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco,String> {

}
