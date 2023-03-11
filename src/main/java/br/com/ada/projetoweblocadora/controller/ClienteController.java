package br.com.ada.projetoweblocadora.controller;

import br.com.ada.projetoweblocadora.model.Cliente;
import br.com.ada.projetoweblocadora.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/c/")
    public String criar(Model model) {
        model.addAttribute("c", Boolean.TRUE);
        model.addAttribute("cliente", new Cliente());
        return "add";
    }

    @PostMapping("/c/")
    public String cadastrar(@ModelAttribute Cliente cliente) {
        this.clienteService.createCliente(cliente);
        return "redirect:/r/";
    }

    @GetMapping("/r/")
    public String listar(Model model) {
        List<Cliente> clientela = this.clienteService.readClientela();
        model.addAttribute("clientela", clientela);
        return "list";
    }

    @GetMapping("/u/{clienteID}/")
    public String editar(Model model, @PathVariable String clienteID) {
        Optional<Cliente> optCliente = this.clienteService.readClienteByID(clienteID);

        if (optCliente.isPresent()) {
            model.addAttribute("cliente", optCliente.get());
        }
        model.addAttribute("add", Boolean.FALSE);

        return "add";
    }

    @PutMapping("/u/{clienteID}/")
    public String atualizar(@ModelAttribute Cliente cliente, @PathVariable String clienteID) {
        cliente.setDocumento(clienteID);
        this.clienteService.createCliente(cliente);
        return "redirect:/r/";
    }

    @GetMapping("/d/{clienteID}/")
    public String remover(@PathVariable String clienteID) {
        this.clienteService.deleteClienteByID(clienteID);
        return "redirect:/r/";
    }
}