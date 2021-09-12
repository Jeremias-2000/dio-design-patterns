package com.dio.padroes.de.projeto.dio.service;

import com.dio.padroes.de.projeto.dio.model.Cliente;

public interface ClienteService {

        Iterable<Cliente> buscarTodos();
        Cliente buscarporId(Long id);
        void inserir(Cliente cliente);
        void atualizar(Long id,Cliente cliente);
        void deletar(Long id);

}
