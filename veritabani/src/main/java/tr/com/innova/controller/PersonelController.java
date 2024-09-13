package tr.com.innova.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.com.innova.dto.ResponseDTO;
import tr.com.innova.entity.Personel;
import tr.com.innova.service.PersonelService;

@RestController
@RequestMapping("/v1/personel")
public class PersonelController {
	@Autowired
	private PersonelService personelService;

	@GetMapping("/all")
	public List<Personel> getAllPersonels() {
		return personelService.getAllPersonels();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Personel> getAllPersonelById(@PathVariable int id) {
		Optional<Personel> oPersonel = personelService.getPersonelById(id);
		if (oPersonel.isPresent()) {
			return ResponseEntity.ok(oPersonel.get());
		} else {
			// return ResponseEntity.status(741).header("deneme", "merhaba").body(new
			// Personel());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("deneme", "merhaba").body(new Personel());
		}
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<List<Personel>> getPersonelByName(@PathVariable String name) throws InterruptedException {
		return ResponseEntity.ok(personelService.getPersonelByName(name));
	}

	@PostMapping("/")
	public ResponseEntity<Personel> updatePersonel(@RequestBody Personel personel) {
		return ResponseEntity.ok(personelService.updatePersonel(personel));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO> deletePersonel(@PathVariable int id) {
		personelService.deletePersonel(id);
		return ResponseEntity.ok(new ResponseDTO("success"));
	}

	@GetMapping("/test")
	public String test() {
		Personel personel = personelService.getPersonelById(1).get();
		System.out.println(personel.getDepartment().getPersonels().size());
		return "personel";
	}

}
