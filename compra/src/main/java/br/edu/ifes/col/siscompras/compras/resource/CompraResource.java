package br.edu.ifes.col.siscompras.compras.resource;

import br.edu.ifes.col.siscompras.compras.service.CompraService;
import br.edu.ifes.col.siscompras.compras.service.dto.ItemCompraDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/compras")
@Slf4j
public class CompraResource {

    private final CompraService compraService;

    @PostMapping
    public ResponseEntity<Void> comprar(@RequestBody List<ItemCompraDTO> itens) {
        compraService.comprar(itens);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
