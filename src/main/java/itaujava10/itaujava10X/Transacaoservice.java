package itaujava10.itaujava10X;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Service
public class Transacaoservice {



private TransacaoRepository transacaoRepositoryV;

    public Transacaoservice(TransacaoRepository transacaoRepositoryV) {
        this.transacaoRepositoryV = transacaoRepositoryV;
    }

    public void validarTrsançao(TransaçaoRequest transaçaoRequestV){
if (transaçaoRequestV.getValor().compareTo(BigDecimal.ZERO) < 0 ) {
    //trancisao nao e valida pq e menor ou igual a zero
    throw  new IllegalArgumentException("Erro:Nao e valida,  pois e menor ou igual a zero");
}
if (transaçaoRequestV.getDataHora().isAfter(OffsetDateTime.now())){
    throw new IllegalArgumentException("erro: na data");
//validaçao da data e hora
}
if (transaçaoRequestV.getDataHora().isAfter(OffsetDateTime.now())) {
        //validaçao da data presente
        throw new  IllegalArgumentException("validaçao da data");
    }
if (transaçaoRequestV.getDataHora().isBefore(OffsetDateTime.now())){
    throw new IllegalArgumentException("validaçao hora");
    }

    }

public void teste(TransacaoRepository transacaoRepositoryV){
        transacaoRepositoryV.ApagarTodosDados();
}
}