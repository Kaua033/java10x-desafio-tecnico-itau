package itaujava10.itaujava10X;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Service
public class Transacaoservice {

    public void validarTrsançao(transaçaoRequest transaçaoRequestV) {
        if (transaçaoRequestV == null) {
            throw new IllegalArgumentException("Transação inválida: corpo da requisição ausente.");
        }

        if (transaçaoRequestV.getValor() == null) {
            throw new IllegalArgumentException("Transação inválida: campo 'valor' é obrigatório.");
        }

        if (transaçaoRequestV.getValor().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Transação inválida: 'valor' não pode ser negativo.");
        }

        if (transaçaoRequestV.getDataHora() == null) {
            throw new IllegalArgumentException("Transação inválida: campo 'dataHora' é obrigatório.");
        }

        if (transaçaoRequestV.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Transação inválida: 'dataHora' não pode estar no futuro.");
        }
    }
}