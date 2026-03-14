package itaujava10.itaujava10X;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransaçaoRequest {

    private BigDecimal valor;
    private OffsetDateTime dataHora;


}



