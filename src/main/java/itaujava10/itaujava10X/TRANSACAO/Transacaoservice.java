package itaujava10.itaujava10X.TRANSACAO;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Service
public class Transacaoservice {



    private final TransacaoRepository transacaoRepositoryV;

    public Transacaoservice(TransacaoRepository transacaoRepositoryV) {
        this.transacaoRepositoryV = transacaoRepositoryV;
    }

    public void validarTrsançao(TransaçaoRequest transaçaoRequestV) {
        if (transaçaoRequestV.getValor() == null || transaçaoRequestV.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        }
        if (transaçaoRequestV.getDataHora() == null) {
            throw new IllegalArgumentException("Data e hora são obrigatórias");
        }
        if (transaçaoRequestV.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Data não pode ser futura");
        }
    }

public void DELECAO(TransacaoRepository transacaoRepositoryV){
        transacaoRepositoryV.ApagarTodosDados();
}

}
