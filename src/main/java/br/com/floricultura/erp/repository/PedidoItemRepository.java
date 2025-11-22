package br.com.floricultura.erp.repository;

import br.com.floricultura.erp.model.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {
}
