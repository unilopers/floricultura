package br.com.floricultura.erp.services;

import br.com.floricultura.erp.model.*;
import br.com.floricultura.erp.repository.PedidoRepository;
import br.com.floricultura.erp.repository.PedidoItemRepository;
import br.com.floricultura.erp.repository.ProdutoRepository;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoItemRepository pedidoItemRepository;
    private final ProdutoRepository produtoRepository;

    public Pedido criarPedido(Pedido pedido) {
        pedido.setDataPedido(LocalDate.now());
        pedido.setStatus("ABERTO");

        BigDecimal total = BigDecimal.ZERO;

        for (PedidoItem item : pedido.getItens()) {
            Produto p = produtoRepository.findById(item.getProduto().getId()).orElseThrow();

            item.setValorUnitario(p.getValorVenda());
            item.setPedido(pedido);

            total = total.add(p.getValorVenda().multiply(BigDecimal.valueOf(item.getQuantidade())));
        }

        pedido.setValorTotal(total);

        Pedido saved = pedidoRepository.save(pedido);

        for (PedidoItem item : pedido.getItens()) {
            Produto p = produtoRepository.findById(item.getProduto().getId()).orElseThrow();
            p.setQuantidadeEstoque(p.getQuantidadeEstoque() - item.getQuantidade());
            produtoRepository.save(p);
        }

        return saved;
    }
}
