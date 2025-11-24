package br.com.floricultura.erp.services;

import br.com.floricultura.erp.model.MovimentacaoEstoque;
import br.com.floricultura.erp.repository.MovimentacaoEstoqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovimentacaoEstoqueService {

    private final MovimentacaoEstoqueRepository repository;

    public List<MovimentacaoEstoque> listarTodas() {
        return repository.findAll();
    }

    public MovimentacaoEstoque salvar(MovimentacaoEstoque movimento) {
        if (movimento.getDataHora() == null) {
            movimento.setDataHora(LocalDateTime.now());
        }
        return repository.save(movimento);
    }
}