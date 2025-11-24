package br.com.floricultura.erp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "MOVIMENTACAO_ESTOQUE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimentacaoEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataMovimentacao;

    @Column(nullable = false)
    private String tipo; // "ENTRADA" (Compra) ou "SAIDA" (Venda/Perda)

    @Column(nullable = false)
    private Integer quantidade;

    @Column(length = 255)
    private String observacao; // Motivo da movimentação

    @ManyToOne
    @JoinColumn(name = "FK_IdProduto", nullable = false)
    private Produto produto;
}