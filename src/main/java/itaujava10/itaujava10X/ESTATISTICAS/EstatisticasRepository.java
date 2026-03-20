package itaujava10.itaujava10X.ESTATISTICAS;

import itaujava10.itaujava10X.TRANSACAO.TransacaoRepository;
import itaujava10.itaujava10X.TRANSACAO.TransaçaoRequest;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

@Repository
public class EstatisticasRepository {

private TransacaoRepository transacaoRepositoryV;
private  TransaçaoRequest transaçaoRequestV;

    public EstatisticasRepository(TransacaoRepository transacaoRepositoryV, TransaçaoRequest transaçaoRequestV) {
        this.transacaoRepositoryV = transacaoRepositoryV;
        this.transaçaoRequestV = transaçaoRequestV;
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


