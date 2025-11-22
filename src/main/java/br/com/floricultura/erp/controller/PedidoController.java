package br.com.floricultura.erp.controller;

import br.com.floricultura.erp.model.*;
import br.com.floricultura.erp.repository.ClienteRepository;
import br.com.floricultura.erp.repository.ProdutoRepository;
import br.com.floricultura.erp.services.PedidoService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pedido")
public class PedidoController {

    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;
    private final PedidoService pedidoService;

    @GetMapping("/novo")
    public String novoPedido(Model model) {
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("produtos", produtoRepository.findAll());
        model.addAttribute("clientes", clienteRepository.findAll());
        return "pedido-form";
    }

    @PostMapping("/salvar")
    public String salvarPedido(@ModelAttribute Pedido pedido) {
        pedidoService.criarPedido(pedido);
        return "redirect:/pedido/novo?sucesso";
    }
}
