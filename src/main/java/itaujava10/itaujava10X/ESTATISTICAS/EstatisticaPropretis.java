package itaujava10.itaujava10X.ESTATISTICAS;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.stereotype.Component;
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "estatistica")

public record EstatisticaPropretis(Integer segundos) {


}
