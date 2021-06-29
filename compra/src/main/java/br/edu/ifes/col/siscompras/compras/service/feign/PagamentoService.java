package br.edu.ifes.col.siscompras.compras.service.feign;

import br.edu.ifes.col.siscompras.compras.service.dto.ItemCompraDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "pagamentoservice", url = "${application.feign.pagamento}")
public interface PagamentoService {

    @GetMapping("/api/pagamentos/liberar/{numCartao}/{valor}")
    void liberar(@PathVariable("numCartao") String cartao, @PathVariable("valor") Float valor);

    @PostMapping("/api/pagamentos/reservar/{numCartao}/{valor}")
    void reservar(@PathVariable("numCartao") String cartao, @PathVariable("valor") Float valor, @RequestBody List<ItemCompraDTO> itens);
}
