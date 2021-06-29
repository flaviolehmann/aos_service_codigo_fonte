package br.edu.ifes.col.siscompras.compras.service;

import br.edu.ifes.col.siscompras.compras.service.dto.ItemCompraDTO;
import br.edu.ifes.col.siscompras.compras.service.exception.RegraNegocioException;
import br.edu.ifes.col.siscompras.compras.service.feign.PagamentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CompraService {

    private final PagamentoService pagamentoService;

    public void comprar(List<ItemCompraDTO> itens) {

        log.info("SISTEMA COMPRAS: Iniciando processo de compra...");

        Float total = itens.stream().reduce(0f, (subtotal, item) -> subtotal + (item.getQuantidade() * item.getValorUnitario()), Float::sum);
        String cartao = "123.456.789.000";

        reservarPagamento(cartao, total, itens);

        log.info("SISTEMA COMPRAS: Saldo reservado..");
    }

    private void reservarPagamento(String cartao, Float total, List<ItemCompraDTO> itens) {
        try {
            log.info("SISTEMA COMPRAS: Acessando serviço de pagamentos... solicitando reserva do saldo");
            pagamentoService.reservar(cartao, total, itens);
        } catch (Exception e) {
            reverterPagamento(cartao, total);
            throw new RegraNegocioException("SISTEMA COMPRAS: Erro ao reservar pagamento");
        }
    }

    private void reverterPagamento(String cartao, Float total) {
        pagamentoService.liberar(cartao, total);
    }
}

