package itaujava10.itaujava10X.ESTATISTICAS;

import itaujava10.itaujava10X.TRANSACAO.TransacaoController;
import itaujava10.itaujava10X.TRANSACAO.TransacaoRepository;
import itaujava10.itaujava10X.TRANSACAO.TransaçaoRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.valves.rewrite.RewriteCond;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.OffsetDateTime;

@Slf4j

@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {

    private final EstatisticasService estatisticasService;
    private final EstatisticaPropretis estatisticaPropretis;
    private final TransacaoRepository transacaoRepository;

    public EstatisticasController(EstatisticasService estatisticasService, EstatisticaPropretis estatisticaPropretis, TransacaoRepository transacaoRepository) {
        this.estatisticasService = estatisticasService;
        this.estatisticaPropretis = estatisticaPropretis;
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping
    public ResponseEntity Estatistica(){
        final  var HoraInicial = OffsetDateTime.now()
                .minusSeconds(estatisticaPropretis.segundos());

        var resultado = transacaoRepository.GetEstatisticas(HoraInicial);

        log.info("Estatísticas geradas - count: {}, sum: {}, avg: {}, min: {}, max: {}",
                resultado.getCount(),
                resultado.getSum(),
                resultado.getAvg(),
                resultado.getMin(),
                resultado.getMax());

        return ResponseEntity.ok(resultado);

       }

    }


