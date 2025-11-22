package br.com.floricultura.erp.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "PEDIDO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DataPedido", nullable = false)
    private LocalDate dataPedido;

    @Column(name = "Status", nullable = false)
    private String status;

    @Column(name = "ValorTotal", nullable = false)
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "FK_IdCliente", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PedidoItem> itens;
}
