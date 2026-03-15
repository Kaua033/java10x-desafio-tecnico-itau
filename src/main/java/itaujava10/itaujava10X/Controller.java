package itaujava10.itaujava10X;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/transasao")
@RestController
public class Controller {
   @Autowired
    private Transacaoservice transacaoservice;
   @Autowired
   private transacaoRepository transacaoRepository;


   @PostMapping
    public ResponseEntity<?> Adicionar(@RequestBody TransaçaoRequest transaçaoRequestV){

    try{transacaoservice.validarTrsançao(transaçaoRequestV);
     transacaoRepository.salvarDados(transaçaoRequestV);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }catch (IllegalArgumentException exception){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}

@DeleteMapping("/deeletar")
    public void AllDeletar(){}

}