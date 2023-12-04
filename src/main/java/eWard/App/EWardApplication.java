package eWard.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class EWardApplication {

	public static void main(String[] args) {
		SpringApplication.run(EWardApplication.class, args);
		log.info("hola");
		log.info("jelouder");
	}

}
