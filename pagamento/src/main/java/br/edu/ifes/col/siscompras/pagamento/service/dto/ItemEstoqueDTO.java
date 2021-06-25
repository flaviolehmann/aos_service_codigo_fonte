package br.edu.ifes.col.siscompras.pagamento.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ItemEstoqueDTO implements Serializable {

    private Integer id;

    private Integer quantidade;

    private Float valorUnitario;
}
