package br.edu.ifes.col.siscompras.compras.service.feign;

import br.edu.ifes.col.siscompras.compras.service.dto.ItemCompraDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "estoqueservice", url = "${application.feign.estoque}")
public interface EstoqueService {

    @PutMapping("/api/estoque/decrementar")
    void decrementar(@RequestBody List<ItemCompraDTO> itens);

    @PutMapping("/api/estoque/incrementar")
    void incrementar(@RequestBody List<ItemCompraDTO> itens);
}
