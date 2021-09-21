package universityspring;

import main.University;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//@EntityScan(value = {"main.dataaccess"})

//@EnableSwagger2
@SpringBootApplication
@EntityScan(value = {"main"})
@ComponentScan(value = {"main"})
@EnableJpaRepositories("main")
public class UniversitySpringApplication {

	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(UniversitySpringApplication.class, args);
		University.UniTests();
		
	}

}
