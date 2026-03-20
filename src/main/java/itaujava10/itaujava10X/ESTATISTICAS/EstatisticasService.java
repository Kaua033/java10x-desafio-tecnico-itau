package itaujava10.itaujava10X.ESTATISTICAS;

import itaujava10.itaujava10X.TRANSACAO.TransaçaoRequest;
import itaujava10.itaujava10X.TRANSACAO.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstatisticasService {

    private TransaçaoRequest transaçaoRequestV;
    private  EstatisticasRepository estatisticasRepositoryV;


    public void GetEstatisticas(TransaçaoRequest transaçaoRequestV) {
  estatisticasRepositoryV.Filtrar60s();

    }

    //TODO:Criar metodos para calcular:
    //  count
    //  sum
    //  avg
    //  min
    //  max
    public void CalcEsatisticas(TransaçaoRequest transaçaoRequestV){


}

}
