package itaujava10.itaujava10X.ESTATISTICAS;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller do endpoint GET /estatistica
 * 
 * Conceito: O Controller só recebe a requisição HTTP e delega a lógica
 * para o Service. Ele NÃO deve conter regras de negócio.
 */
@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {

    private final EstatisticasService estatisticasService;

    public EstatisticasController(EstatisticasService estatisticasService) {
        this.estatisticasService = estatisticasService;
    }

    /**
     * GET /estatistica
     * Retorna estatísticas das transações dos últimos 60 segundos.
     * Resposta: { count, sum, avg, min, max }
     */
    @GetMapping
    public ResponseEntity<estatisticaDTO> getEstatisticas() {
        estatisticaDTO estatisticas = estatisticasService.calcularEstatisticas();
        return ResponseEntity.ok(estatisticas);
    }
}