package tr.com.innova;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix = "test")
public class Personel {
	private String adi;
	private String soyadi;
	private String url;
	private String username;
	private String password;
}
