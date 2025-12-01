package br.com.floricultura.erp.controller;

import br.com.floricultura.erp.model.Colaborador;
import br.com.floricultura.erp.services.ColaboradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/colaboradores")
@RequiredArgsConstructor
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    @GetMapping
    public ResponseEntity<List<Colaborador>> listar() {
        return ResponseEntity.ok(colaboradorService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Colaborador> salvar(@RequestBody Colaborador colaborador) {
        return ResponseEntity.ok(colaboradorService.salvar(colaborador));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(colaboradorService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        colaboradorService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}