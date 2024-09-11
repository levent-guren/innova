package tr.com.innova.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tr.com.innova.dto.Personel;

@RestController
public class PersonelController {

	@GetMapping("/merhaba")
	public String merhaba() {
		System.out.println("merhaba çagirildi");
		return "Merhaba2";
	}

	@GetMapping("/kaydet2")
	public String kaydet2(@RequestParam(name = "adi", required = false, defaultValue = "isimsiz") String isim,
			int yas) {
		return "Kaydedildi. Adı: " + isim + ", yas: " + yas * 2;
	}

	@GetMapping("/kaydet")
	public String kaydet(Personel personel) {
		return "Kaydedildi. Personel: " + personel;
	}

	@GetMapping("/kaydet3")
	public Personel kaydet3(Personel personel) {
		return personel;
	}

}
