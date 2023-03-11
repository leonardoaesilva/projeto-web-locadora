package br.com.ada.projetoweblocadora.controller;

import br.com.ada.projetoweblocadora.model.Cliente;
import br.com.ada.projetoweblocadora.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientela")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/c")
    public ResponseEntity<String> createCliente(@RequestBody Cliente cliente) {
        try {
            this.clienteService.createCliente(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cliente criado!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/r")
    public List<Cliente> readClientela() {
        return this.clienteService.readClientela();
    }

    @GetMapping("/r/{documento}")
    public ResponseEntity<Cliente> readClienteByID(@PathVariable String documento) {
        Optional<Cliente> optCliente = this.clienteService.readClienteByID(documento);

        if (optCliente.isPresent()) {
            return ResponseEntity.ok(optCliente.get());
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/u")
    public ResponseEntity<String> updateCliente(@RequestBody Cliente cliente) {
        try {
            Optional<Cliente> optCliente = this.clienteService.readClienteByID(cliente.getDocumento());

            if (optCliente.isPresent()) {
                this.clienteService.deleteClienteByID(cliente.getDocumento());
                this.clienteService.createCliente(cliente);

                return ResponseEntity.ok("Dados atualizados com sucesso!");
            }

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/d/{documento}")
    public void deleteClienteByID(@PathVariable String documento) {
        this.clienteService.deleteClienteByID(documento);
    }
}
