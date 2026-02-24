package itaujava10.itaujava10X;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/transasao")
@RestController
public class Controller {
   @Autowired
    private service service;

@PostMapping
    public ResponseEntity<?> Adicionar(@RequestBody transaçaoRequest transaçaoRequestV{
    service.validarTrsançao(transaçaoRequestV);
    return ResponseEntity.status(HttpStatus.CREATED).build();
}


}