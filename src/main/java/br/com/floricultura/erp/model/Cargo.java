package br.com.floricultura.erp.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nomeCargo;

    @Column(columnDefinition = "TEXT")
    private String descricao;
}