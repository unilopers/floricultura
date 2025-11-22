package br.com.floricultura.erp.controller;

import br.com.floricultura.erp.model.Produto;
import br.com.floricultura.erp.services.ProdutoService;
import br.com.floricultura.erp.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/produtos")
    public String listar(Model model) {
        model.addAttribute("produtos", produtoService.listarTodos());
        return "produtos/lista";
    }

    @GetMapping("/produtos/novo")
    public String novo(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("fornecedores", fornecedorService.listarTodos());
        model.addAttribute("atualizar", false);
        return "produtos/cadastro";
    }

    @GetMapping("/produtos/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Produto produto = produtoService.buscarPorId(id).orElse(new Produto());

        model.addAttribute("produto", produto);
        model.addAttribute("fornecedores", fornecedorService.listarTodos());
        model.addAttribute("atualizar", true);
        return "produtos/cadastro";
    }

    @PostMapping("/produtos/salvar")
    public String salvar(Produto produto) {
        produtoService.salvar(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/produtos/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        produtoService.excluir(id);
        return "redirect:/produtos";
    }
}