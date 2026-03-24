package itaujava10.itaujava10X.ESTATISTICAS;

import itaujava10.itaujava10X.TRANSACAO.TransacaoRepository;
import itaujava10.itaujava10X.TRANSACAO.TransaçaoRequest;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EstatisticasRepository {

    private final TransacaoRepository transacaoRepositoryV;

    public EstatisticasRepository(TransacaoRepository transacaoRepositoryV) {
        this.transacaoRepositoryV = transacaoRepositoryV;
    }

    // Metodo para filtrar
    public  List<TransaçaoRequest> Filtrar60s(){
   OffsetDateTime Agora = OffsetDateTime.now();
   OffsetDateTime sesentaS = Agora.minusSeconds(60);

        return transacaoRepositoryV.listarTodas()
                .stream()
                .filter(t ->!t.getDataHora().isBefore(sesentaS))
                .filter(t -> !t.getDataHora().isAfter(Agora))
                .collect(Collectors.toList());

    }
}

