package itaujava10.itaujava10X.ESTATISTICAS;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "estatistica")
public record EstatisticaPropretis(Integer segundos) {


    public EstatisticaPropretis(
            @NotNull
            @Positive
            Integer segundos
    ) {
        this.segundos = segundos;
    }
}
