package br.com.floricultura.erp.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PEDIDO_ITEM")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "ValorUnitario", nullable = false)
    private BigDecimal valorUnitario;

    @ManyToOne
    @JoinColumn(name = "FK_IdPedido", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "FK_IdProduto", nullable = false)
    private Produto produto;
}
