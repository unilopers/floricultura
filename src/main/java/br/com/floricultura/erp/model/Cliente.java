package br.com.floricultura.erp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "CLIENTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 120)
    private String email;

    private LocalDate dataNascimento;

    @Column(length = 150)
    private String endereco;

    @Column(length = 8)
    private String cep;

    @Column(length = 15)
    private String telefone;

    @Column(length = 11, unique = true)
    private String cpf;

    @OneToOne
    @JoinColumn(name = "FK_IdUsuario", referencedColumnName = "id")
    private Usuario usuario;

    @PrePersist
    @PreUpdate
    private void validarCPF() {
        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("CPF é obrigatório.");
        }

        if (!cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF deve conter exatamente 11 dígitos numéricos.");
        }

        if (cpf.chars().distinct().count() == 1) {
            throw new IllegalArgumentException("CPF inválido.");
        }
    }
}
