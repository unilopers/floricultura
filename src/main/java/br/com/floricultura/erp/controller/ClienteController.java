package br.com.floricultura.erp.controller;

import br.com.floricultura.erp.model.Cliente;
import br.com.floricultura.erp.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarTodos());
        return "clientes";
    }

    @GetMapping("/clientes/novo")
    public String novoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente-form";
    }

    @PostMapping("/clientes")
    public String salvar(Cliente cliente) {
        clienteService.salvar(cliente);
        return "redirect:/clientes";
    }
}
