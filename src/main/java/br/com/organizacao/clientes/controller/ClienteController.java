package br.com.organizacao.clientes.controller;

import br.com.organizacao.clientes.model.Cliente;
import br.com.organizacao.clientes.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteService.criarCliente(cliente);
    }

    @GetMapping("/{id}")
    public Cliente buscarCliente(@PathVariable("id") long id) {
        return clienteService.buscarCliente(id);
    }

    @GetMapping
    public List<Cliente> buscarTodosClientes() {
        return clienteService.buscarTodosClientes();
    }

    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable long id, @RequestBody Cliente cliente) {
        cliente.setId(id);

        return clienteService.atualizarCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable long id) {
        clienteService.deletarCliente(id);
    }

}
