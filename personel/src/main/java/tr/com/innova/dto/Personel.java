package tr.com.innova.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Personel {
	private String email;
	@NotNull
	private String adi;
	@DecimalMin(value = "10", message = "Yaşı en az 10 verilmelidir")
	private String yasi;
}
