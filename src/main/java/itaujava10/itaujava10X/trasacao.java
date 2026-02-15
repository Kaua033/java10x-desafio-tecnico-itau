package itaujava10.itaujava10X;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class trasacao {

    private BigDecimal valor;
    private OffsetDateTime dataHora;


    //O uso dos getter e setter feitos manualmente se da por conta de possiveis problemas do Spring boot, levando em conta experiencias passadas
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }
}