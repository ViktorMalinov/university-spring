package universityspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(value = {"main.dataaccess"})
@ComponentScan(value = {"main"})
public class UniversitySpringApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(UniversitySpringApplication.class, args);
		//University.UniTests();
	}

}
