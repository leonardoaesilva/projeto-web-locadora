package br.com.ada.projetoweblocadora.service;

import br.com.ada.projetoweblocadora.model.Cliente;
import br.com.ada.projetoweblocadora.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public void createCliente(Cliente cliente) {
        this.clienteRepository.save(cliente);
    }

    public List<Cliente> readClientela() {
        return this.clienteRepository.findAll();
    }

    public Optional<Cliente> readClienteByID(String documento) {
        return this.clienteRepository.findById(documento);
    }

    public void deleteClienteByID(String documento) {
        this.clienteRepository.deleteById(documento);
    }
}
