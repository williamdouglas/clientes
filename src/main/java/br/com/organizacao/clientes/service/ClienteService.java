package br.com.organizacao.clientes.service;

import br.com.organizacao.clientes.exception.ClienteNotFoundException;
import br.com.organizacao.clientes.model.Cliente;
import br.com.organizacao.clientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscarCliente(long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado"));
    }

    public List<Cliente> buscarTodosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente atualizarCliente(Cliente cliente) {
        Cliente clienteRetornado = clienteRepository.findById(cliente.getId())
                        .orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado"));

        clienteRetornado.setNome(cliente.getNome());
        clienteRetornado.setEmail(cliente.getEmail());
        clienteRetornado.setTelefone(cliente.getTelefone());

        return clienteRepository.save(clienteRetornado);
    }

    public void deletarCliente(long id) {
        clienteRepository.deleteById(id);
    }

}
