package itaujava10.itaujava10X;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/estatisca")
public class EstatisticasController {

    //criar rota de logica de estatistica

    @GetMapping("/")
    public ResponseEntity get() {
        return null;
    }
}