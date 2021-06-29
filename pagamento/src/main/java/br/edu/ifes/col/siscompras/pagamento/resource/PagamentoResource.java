package br.edu.ifes.col.siscompras.pagamento.resource;

import br.edu.ifes.col.siscompras.pagamento.service.PagamentoService;
import br.edu.ifes.col.siscompras.pagamento.service.dto.ItemCompraDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pagamentos")
@Slf4j
public class PagamentoResource {

    private final PagamentoService pagamentoService;

    @GetMapping("/liberar/{numCartao}/{valor}")
    public ResponseEntity<Void> liberar(@PathVariable("numCartao") String cartao, @PathVariable("valor") Float valor) {
        log.info("SISTEMA PAGAMENTOS: Pagamento realizado com sucesso...");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/reservar/{numCartao}/{valor}")
    public ResponseEntity<Void> reservar(@PathVariable("numCartao") String cartao, @PathVariable("valor") Float valor,
                                         @RequestBody List<ItemCompraDTO> itens) {
        pagamentoService.reservar(cartao, valor, itens);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
