package br.com.floricultura.erp.repository;

import br.com.floricultura.erp.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
    Optional<Colaborador> findByCpf(String cpf);
    Optional<Colaborador> findByMatricula(String matricula);
}