package br.edu.ifes.col.siscompras.estoque.service;

import br.edu.ifes.col.siscompras.estoque.service.dto.ItemEstoqueDTO;
import br.edu.ifes.col.siscompras.estoque.service.exception.RegraNegocioException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class ItemEstoqueService {

    public void incrementar(List<ItemEstoqueDTO> itens) {
        log.info("APLICAÇÃO ESTOQUE: Incremento de estoque realizado com sucesso...");
    }

    public void decrementar(List<ItemEstoqueDTO> itens) {

        for (ItemEstoqueDTO item : itens) {
            log.info("APLICAÇÃO ESTOQUE: Atualizando estoque do item de estoque com ID {}", item.getId());

            Random gerador = new Random();
            int val = gerador.nextInt(6);

            if(val == 0) {
                log.error("APLICAÇÃO ESTOQUE: Erro ao atualizar estoque do item de estoque com ID {}", item.getId());
                throw new RegraNegocioException("Erro ao atualizar estoque");
            }

            log.info("Atualiação de estoque realizada com sucesso...");

        }
    }
}
