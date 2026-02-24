package itaujava10.itaujava10X;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class estatisticaDTO {
  private final   Long count;
    private final  Double sum;
    private final Double avg;
    private final    Double min;
    private final  Double max;

    public estatisticaDTO(Long count, Double sum, Double avg, Double min, Double max) {
        this.count = count;
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;
    }
}