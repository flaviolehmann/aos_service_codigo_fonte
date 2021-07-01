package br.edu.ifes.col.siscompras.pagamento.service;

import br.edu.ifes.col.siscompras.pagamento.service.dto.ItemCompraDTO;
import br.edu.ifes.col.siscompras.pagamento.service.exception.RegraNegocioException;
import br.edu.ifes.col.siscompras.pagamento.service.feign.EstoqueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Slf4j
@RequiredArgsConstructor
public class PagamentoService {

    private final EstoqueService estoqueService;

    public void reservar(String cartao, Float valor, List<ItemCompraDTO> itens) {

        log.info("SISTEMA PAGAMENTOS: Reservando saldo");

        Random gerador = new Random();
        int val = gerador.nextInt(4);

        if(val == 0) {
            throw new RegraNegocioException("Erro ao reservar pagamento");
        }

        log.info("SISTEMA PAGAMENTOS: Saldo reservado com sucesso");

        decrementarEstoque(itens);

        log.info("SISTEMA PAGAMENTOS: Estoque decrementado...");
        log.info("SISTEMA PAGAMENTOS: Finalizando processo de compra...");

        val = gerador.nextInt(3);

        if(val == 0) {
            log.error("SISTEMA PAGAMENTOS: Erro ao finalizar processamento de compra...");
            log.info("SISTEMA PAGAMENTOS: Pagamento realizado com sucesso...");
            reverterEstoque(itens);
            throw new RegraNegocioException("Erro ao finalizar compra");
        }

        log.info("SISTEMA PAGAMENTOS: Processamento de compra finalizado com sucesso...");
    }

    private void decrementarEstoque(List<ItemCompraDTO> itens) {
        try {
            log.info("SISTEMA PAGAMENTOS: Acessando serviço de controle de estoque...");
            estoqueService.decrementar(itens);
        } catch (Exception e) {
            reverterEstoque(itens);
            throw new RegraNegocioException("SISTEMA PAGAMENTOS: Erro ao decrementar estoque");
        }
    }

    private void reverterEstoque(List<ItemCompraDTO> itens) {
        estoqueService.incrementar(itens);
    }

}
