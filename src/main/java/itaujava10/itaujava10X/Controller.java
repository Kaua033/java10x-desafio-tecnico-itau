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

@PostMapping
    public ResponseEntity<?> Adicionar(@RequestBody transaçaoRequest transaçaoRequestV){
    try{transacaoservice.validarTrsançao(transaçaoRequestV);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }catch (IllegalArgumentException exception){

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY ).build();
    }
}


}