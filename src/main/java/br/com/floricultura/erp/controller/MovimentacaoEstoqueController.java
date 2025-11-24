package br.com.floricultura.erp.controller;

import br.com.floricultura.erp.model.MovimentacaoEstoque;
import br.com.floricultura.erp.repository.MovimentacaoEstoqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/movimentacoes")
@RequiredArgsConstructor
public class MovimentacaoEstoqueController {

    private final MovimentacaoEstoqueRepository repository;

    @GetMapping
    public ResponseEntity<List<MovimentacaoEstoque>> listar() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<MovimentacaoEstoque> salvar(@RequestBody MovimentacaoEstoque mov) {
        mov.setDataHora(LocalDateTime.now());
        return ResponseEntity.ok(repository.save(mov));
    }
}