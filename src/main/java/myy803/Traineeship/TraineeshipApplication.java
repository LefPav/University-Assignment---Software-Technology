package myy803.Traineeship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "myy803.Traineeship.mappers")
@ComponentScan("myy803.Traineeship")
@SpringBootApplication
public class TraineeshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraineeshipApplication.class, args);
	}

}
