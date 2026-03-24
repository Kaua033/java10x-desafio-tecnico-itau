package itaujava10.itaujava10X.ESTATISTICAS;

import itaujava10.itaujava10X.TRANSACAO.TransaçaoRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EstatisticasService {

    private final EstatisticasRepository estatisticasRepositoryV;

    public EstatisticasService(EstatisticasRepository estatisticasRepositoryV) {
        this.estatisticasRepositoryV = estatisticasRepositoryV;
    }

    public estatisticaDTO GetEstatisticas() {
        List<TransaçaoRequest> transacoes = estatisticasRepositoryV.Filtrar60s();
        return CalcEstatisticas(transacoes);
    }

    /**
     * Calcula as estatísticas (count, sum, avg, min, max) a partir de uma lista de transações.
     */
    public estatisticaDTO CalcEstatisticas(List<TransaçaoRequest> transacoes) {
        if (transacoes == null || transacoes.isEmpty()) {
            return new estatisticaDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }

        long count = transacoes.size();
        double sum = transacoes.stream()
                .map(TransaçaoRequest::getValor)
                .mapToDouble(BigDecimal::doubleValue)
                .sum();
        double avg = sum / count;
        double min = transacoes.stream()
                .map(TransaçaoRequest::getValor)
                .mapToDouble(BigDecimal::doubleValue)
                .min()
                .orElse(0.0);
        double max = transacoes.stream()
                .map(TransaçaoRequest::getValor)
                .mapToDouble(BigDecimal::doubleValue)
                .max()
                .orElse(0.0);

        return new estatisticaDTO(count, sum, avg, min, max);
    }

}
