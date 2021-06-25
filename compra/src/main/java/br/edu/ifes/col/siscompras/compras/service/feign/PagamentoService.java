package br.edu.ifes.col.siscompras.compras.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pagamentoservice", url = "${application.feign.pagamento}")
public interface PagamentoService {

    @GetMapping("/api/pagamentos/liberar/{numCartao}/{valor}")
    void liberar(@PathVariable("numCartao") String cartao, @PathVariable("valor") Float valor);

    @GetMapping("/api/pagamentos/reservar/{numCartao}/{valor}")
    void reservar(@PathVariable("numCartao") String cartao, @PathVariable("valor") Float valor);
}
