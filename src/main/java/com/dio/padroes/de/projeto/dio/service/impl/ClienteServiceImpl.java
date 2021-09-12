package com.dio.padroes.de.projeto.dio.service.impl;

import com.dio.padroes.de.projeto.dio.model.Cliente;
import com.dio.padroes.de.projeto.dio.model.ClienteRepository;
import com.dio.padroes.de.projeto.dio.model.Endereco;
import com.dio.padroes.de.projeto.dio.model.EnderecoRepository;
import com.dio.padroes.de.projeto.dio.service.ClienteService;
import com.dio.padroes.de.projeto.dio.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarporId(Long id) {
        Optional<Cliente> cliente =  clienteRepository.findById(id);
         return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }


    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBD =  clienteRepository.findById(id);
        if (clienteBD.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);

    }
    private void salvarClienteComCep(Cliente cliente){
        String cep = cliente.getEndereco().getCep();
        //verifica se existe endereco
        Endereco endereco =  enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
