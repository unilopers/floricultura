package br.com.floricultura.erp.controller;

import br.com.floricultura.erp.model.Cargo;
import br.com.floricultura.erp.services.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cargos")
@RequiredArgsConstructor
public class CargoController {

    private final CargoService service;

    @GetMapping
    public ResponseEntity<List<Cargo>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Cargo> salvar(@RequestBody Cargo cargo) {
        return ResponseEntity.ok(service.salvar(cargo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}