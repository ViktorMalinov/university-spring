package universityspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EntityScan(value = {"main.dataaccess"})

@SpringBootApplication
@EntityScan(value = {"main"})
@ComponentScan(value = {"main"})
@EnableJpaRepositories("main")
public class UniversitySpringApplication {

	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(UniversitySpringApplication.class, args);
		//University.UniTests();
		
	}

}
