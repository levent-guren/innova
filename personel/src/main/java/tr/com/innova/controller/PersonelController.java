package tr.com.innova.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tr.com.innova.dto.Personel;

@RestController
public class PersonelController {

	@GetMapping("/kaydet")
	public String kaydet(@Valid Personel personel) {
		return "Kaydedildi.";
	}
}
