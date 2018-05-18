package gr.codehub.teamb.acmeshop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class AcmeshopApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(AcmeshopApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

	}
}
