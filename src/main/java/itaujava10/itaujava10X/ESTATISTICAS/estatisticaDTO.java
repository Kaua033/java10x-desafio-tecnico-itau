package itaujava10.itaujava10X.ESTATISTICAS;

import lombok.Getter;

@Getter
public class estatisticaDTO {
  private final   int count;
    private final  Double sum;
    private final Double avg;
    private final    Double min;
    private final  Double max;

    public estatisticaDTO(int count, Double sum, Double avg, Double min, Double max) {
        this.count = count;
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;
    }
}