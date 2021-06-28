package universityspring;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import main.University;

@SpringBootApplication
public class UniversitySpringApplication {

	public static void main(String[] args) throws Exception {
		//SpringApplication.run(UniversitySpringApplication.class, args);
		University.UniTests();
	}

}
