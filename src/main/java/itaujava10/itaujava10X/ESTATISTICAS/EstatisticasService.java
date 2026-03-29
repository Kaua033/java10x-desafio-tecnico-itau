package itaujava10.itaujava10X.ESTATISTICAS;

import itaujava10.itaujava10X.TRANSACAO.TransacaoRepository;
import itaujava10.itaujava10X.TRANSACAO.TransaçaoRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EstatisticasService {


    private  final TransacaoRepository transacaoRepository;

    public EstatisticasService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }




}
