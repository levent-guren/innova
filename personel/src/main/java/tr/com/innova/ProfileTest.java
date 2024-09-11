package tr.com.innova;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProfileTest implements CommandLineRunner {
	@Value("${databaseadi:database adi yok}")
	private String database;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Database: " + database);
	}

}
