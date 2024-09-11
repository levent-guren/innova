package tr.com.innova;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

	@Bean
	@Qualifier("prod")
	Database getDatabase() {
		Database db = new Database();
		db.setUsername("prod");
		db.setPassword("db123!");
		return db;
	}

	@Bean
	Database getDatabase2() {
		Database db = new Database();
		db.setUsername("prod_2");
		db.setPassword("db123!");
		return db;
	}
}
