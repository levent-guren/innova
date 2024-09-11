package tr.com.innova;

import lombok.Data;

@Data
public class Database {
	private String username;
	private String password;

	public void connect() {
		System.out.println("Database connected...");
	}
}
