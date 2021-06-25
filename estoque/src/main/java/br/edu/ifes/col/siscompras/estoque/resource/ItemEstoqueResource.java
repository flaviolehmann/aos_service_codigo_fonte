package br.edu.ifes.col.siscompras.estoque.resource;

import br.edu.ifes.col.siscompras.estoque.service.ItemEstoqueService;
import br.edu.ifes.col.siscompras.estoque.service.dto.ItemEstoqueDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/estoque")
public class ItemEstoqueResource {

    private final ItemEstoqueService itemEstoqueService;

    @PutMapping("/decrementar")
    public ResponseEntity<Void> decrementar(@RequestBody List<ItemEstoqueDTO> itens) {
        itemEstoqueService.decrementar(itens);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/incrementar")
    public ResponseEntity<Void> incrementar(@RequestBody List<ItemEstoqueDTO> itens) {
        itemEstoqueService.incrementar(itens);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
