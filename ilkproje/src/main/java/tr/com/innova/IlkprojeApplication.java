package tr.com.innova;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Data;

@SpringBootApplication
@Data
public class IlkprojeApplication implements CommandLineRunner {
	@Autowired
	private Personel personel;
	@Autowired
	@Qualifier("prod")
	private Database database;

	public static void main(String[] args) {
		SpringApplication.run(IlkprojeApplication.class, args);
	}

	void test() {
		System.out.println(personel);
		System.out.println(database);
	}

	@Override
	public void run(String... args) throws Exception {
		test();
	}

}
