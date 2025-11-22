package br.com.floricultura.erp.controller;

import br.com.floricultura.erp.model.Colaborador;
import br.com.floricultura.erp.services.CargoService;
import br.com.floricultura.erp.services.ColaboradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/colaboradores")
@RequiredArgsConstructor
public class ColaboradorController {

    private final ColaboradorService colaboradorService;
    private final CargoService cargoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaColaboradores", colaboradorService.listarTodos());
        return "colaborador/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("colaborador", new Colaborador());
        model.addAttribute("listaCargos", cargoService.listarTodos());
        return "colaborador/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Colaborador colaborador) {
        colaboradorService.salvar(colaborador);
        return "redirect:/colaboradores";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("colaborador", colaboradorService.buscarPorId(id));
        model.addAttribute("listaCargos", cargoService.listarTodos());
        return "colaborador/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        colaboradorService.excluir(id);
        return "redirect:/colaboradores";
    }
}