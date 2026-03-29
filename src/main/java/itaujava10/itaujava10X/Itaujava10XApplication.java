package itaujava10.itaujava10X;

import itaujava10.itaujava10X.ESTATISTICAS.EstatisticaPropretis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationPropertiesScan
@SpringBootApplication

public class Itaujava10XApplication {

	public static void main(String[] args) {
		SpringApplication.run(Itaujava10XApplication.class, args);
	}

}

