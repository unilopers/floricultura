package br.com.floricultura.erp.async;

import br.com.floricultura.erp.model.Fornecedor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CnpjValidatorAsync {

    @Async
    public void validarCnpj(Fornecedor fornecedor) {
        try {
            Thread.sleep(3000); // simula chamada para API externa

            log.info("CNPJ validado com sucesso: {}", fornecedor.getCnpj());

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Erro ao validar CNPJ: {}", e.getMessage());
        }
    }
}