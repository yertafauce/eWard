package eWard.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EntityScan({"eWard.entity"})
@EnableScheduling
public class ZkConfigAppStartApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ZkConfigAppStartApplication.class, args);
		
	}

}
