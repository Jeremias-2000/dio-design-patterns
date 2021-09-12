package com.dio.padroes.de.projeto.dio.controller;

import com.dio.padroes.de.projeto.dio.model.Cliente;
import com.dio.padroes.de.projeto.dio.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    private ResponseEntity<Iterable<Cliente>> buscarTodos(){
        return ResponseEntity.ok(clienteService.buscarTodos());
    }


    @GetMapping("/{id}")
    private ResponseEntity<Cliente> buscarPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(clienteService.buscarporId(id));
    }

    @PostMapping
    private ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente){
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }
    @PutMapping("/{id}")
    private ResponseEntity<Cliente> atualizar(@PathVariable("id") Long id,@RequestBody Cliente cliente){
        clienteService.atualizar(id,cliente);
        return ResponseEntity.ok(cliente);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
