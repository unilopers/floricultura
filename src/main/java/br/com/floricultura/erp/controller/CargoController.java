package br.com.floricultura.erp.controller;

import br.com.floricultura.erp.model.Cargo;
import br.com.floricultura.erp.services.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cargos")
@RequiredArgsConstructor
public class CargoController {

    private final CargoService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaCargos", service.listarTodos());
        return "cargo/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("cargo", new Cargo());
        return "cargo/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Cargo cargo) {
        service.salvar(cargo);
        return "redirect:/cargos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("cargo", service.buscarPorId(id));
        return "cargo/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        try {
            service.excluir(id);
        } catch (Exception e) {
            return "redirect:/cargos?erro=true";
        }
        return "redirect:/cargos";
    }
}