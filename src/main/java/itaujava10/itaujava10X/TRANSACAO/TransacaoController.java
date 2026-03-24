package itaujava10.itaujava10X.TRANSACAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RequestMapping("/transasao")
@RestController
public class TransacaoController {
   @Autowired
    private Transacaoservice transacaoservice;
   @Autowired
   private TransacaoRepository transacaoRepository;


   @PostMapping("/add")
    public ResponseEntity<?> Adicionar(@RequestBody TransaçaoRequest transaçaoRequestV){

    try{
        transacaoservice.validarTrsançao(transaçaoRequestV);
        transacaoRepository.salvarDados(transaçaoRequestV);
        return ResponseEntity.status(HttpStatus.CREATED).body(transaçaoRequestV);
    }catch (IllegalArgumentException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}

    /**
     * Endpoint para teste: adiciona transação com data/hora atual automaticamente.
     * Envie apenas: { "valor": 150.50 }
     */
    @PostMapping("/add/agora")
    public ResponseEntity<?> AdicionarAgora(@RequestBody TransaçaoRequest request) {
        TransaçaoRequest comDataAtual = new TransaçaoRequest(
                request.getValor(),
                OffsetDateTime.now()
        );
        return Adicionar(comDataAtual);
    }

@DeleteMapping("/deeletar")
    public ResponseEntity  AllDeletar(){
       transacaoRepository.ApagarTodosDados();
       return  ResponseEntity.status(HttpStatus.OK).build();
}

}