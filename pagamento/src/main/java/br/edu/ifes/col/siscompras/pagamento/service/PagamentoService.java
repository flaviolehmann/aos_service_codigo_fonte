package br.edu.ifes.col.siscompras.pagamento.service;

import br.edu.ifes.col.siscompras.pagamento.service.exception.RegraNegocioException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class PagamentoService {

    public void reservar(String cartao, Float valor) {

        log.info("SISTEMA PAGAMENTOS: Reservando saldo");

        Random gerador = new Random();
        int val = gerador.nextInt(4);

        if(val == 0) {
            throw new RegraNegocioException("Erro ao reservar pagamento");
        }

        log.info("SISTEMA PAGAMENTOS: Saldo reservado com sucesso");
    }
}
