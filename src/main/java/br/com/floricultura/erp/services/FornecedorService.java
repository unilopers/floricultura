package br.com.floricultura.erp.services;

import br.com.floricultura.erp.model.Fornecedor;
import br.com.floricultura.erp.repository.FornecedorRepository;
import br.com.floricultura.erp.async.CnpjValidatorAsync;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    // 🔥 injeção do async
    @Autowired
    private CnpjValidatorAsync cnpjValidatorAsync;

    // 🔥 MÉTODO PRINCIPAL COM ASYNC
    public Fornecedor salvar(Fornecedor fornecedor) {
        Fornecedor saved = fornecedorRepository.save(fornecedor);

        // chamada assíncrona (não bloqueia)
        cnpjValidatorAsync.validarCnpj(saved);

        return saved;
    }

    public List<Fornecedor> listarTodos() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> buscarPorId(Long id) {
        return fornecedorRepository.findById(id);
    }

    public Fornecedor atualizar(Long id, Fornecedor fornecedorDetalhes) {
        return fornecedorRepository.findById(id)
                .map(fornecedorExistente -> {
                    fornecedorExistente.setNome(fornecedorDetalhes.getNome());
                    fornecedorExistente.setCnpj(fornecedorDetalhes.getCnpj());
                    fornecedorExistente.setEndereco(fornecedorDetalhes.getEndereco());
                    fornecedorExistente.setCep(fornecedorDetalhes.getCep());
                    fornecedorExistente.setTelefone(fornecedorDetalhes.getTelefone());

                    return fornecedorRepository.save(fornecedorExistente);
                }).orElse(null);
    }

    public boolean excluir(Long id) {
        if (fornecedorRepository.existsById(id)) {
            fornecedorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}