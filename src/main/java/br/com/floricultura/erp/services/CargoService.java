package br.com.floricultura.erp.services;

import br.com.floricultura.erp.model.Cargo;
import br.com.floricultura.erp.repository.CargoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CargoService {

    private final CargoRepository repository;

    public List<Cargo> listarTodos() {
        return repository.findAll();
    }

    public Cargo buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
    }

    public Cargo salvar(Cargo cargo) {
        return repository.save(cargo);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}