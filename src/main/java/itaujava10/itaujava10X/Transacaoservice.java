package itaujava10.itaujava10X;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Service
public class Transacaoservice {


    @Autowired
    private transaçaoRequest transaçaoRequest;



    public void validarTrsançao(transaçaoRequest transaçaoRequestV){
if (transaçaoRequest.getValor().compareTo(BigDecimal.ZERO) < 0 ) {
    //trancisao nao e valida pq e menor ou igual a zero
    throw  new IllegalArgumentException("Erro:Nao e valida,  pois e menor ou igual a zero");
}
if (transaçaoRequest.getDataHora().isAfter(OffsetDateTime.now())){
    throw new IllegalArgumentException("erro: na data");
//validaçao da data e hora
}
if (transaçaoRequest.getDataHora().isAfter(OffsetDateTime.now())) {
        //validaçao da data presente
        throw new  IllegalArgumentException("validaçao da data");
    }
if (transaçaoRequest.getDataHora().isBefore(OffsetDateTime.now())){
    throw new IllegalArgumentException("validaçao hora");
    }

    }
}