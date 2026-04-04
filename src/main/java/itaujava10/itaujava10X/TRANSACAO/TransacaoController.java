package itaujava10.itaujava10X.TRANSACAO;

import itaujava10.itaujava10X.ESTATISTICAS.EstatisticaPropretis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@RequestMapping("/transasao")
@RestController
public class TransacaoController {

    private final Transacaoservice transacaoservice;
    private final TransacaoRepository transacaoRepository;
private final EstatisticaPropretis estatisticaPropretis;
    public TransacaoController(Transacaoservice transacaService, TransacaoRepository transacaoRepository, EstatisticaPropretis estatisticaPropretis) {
        this.transacaoservice = transacaService;
        this.transacaoRepository = transacaoRepository;
        this.estatisticaPropretis = estatisticaPropretis;
    }

    @PostMapping("/add")
    public ResponseEntity<?> Adicionar(@RequestBody TransaçaoRequest transaçaoRequestV) {

            try{
                transacaoservice.validarTrsançao(transaçaoRequestV);
                transacaoRepository.salvarDados(transaçaoRequestV);
                log.info("Trnsação Criada com suscesso : {}", transaçaoRequestV.getValor(),transaçaoRequestV.getDataHora());
                return ResponseEntity.status(HttpStatus.CREATED).body(transaçaoRequestV);
            } catch (IllegalArgumentException exception) {
                log.error("Erro de validação: {}", exception.getMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }


    @DeleteMapping("/deeletar")
    public ResponseEntity<Void> allDeletar() {
       log.info("Dados Apagados com suscesso: ");
        transacaoRepository.ApagarTodosDados();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
