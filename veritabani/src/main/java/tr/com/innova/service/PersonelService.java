package tr.com.innova.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tr.com.innova.entity.Personel;
import tr.com.innova.repository.PersonelRepository;

@Service
public class PersonelService implements CommandLineRunner {
	@Autowired
	private PersonelRepository personelRepository;

	public List<Personel> getAllPersonels() {
		return personelRepository.findAll();
	}

	public Optional<Personel> getPersonelById(int id) {
		return personelRepository.findById(id);
	}

	public List<Personel> getPersonelByName(String name) throws InterruptedException {
		List<Personel> result = personelRepository.findByNameContaining(name);
		if (result.size() == 0) {
			throw new RuntimeException("Kayit bulunamadi");
		}
		return result;
	}

	public void deletePersonel(int id) {
		personelRepository.deleteById(id);
	}

	@Transactional
	public Personel updatePersonel(Personel personel) {
		return personelRepository.save(personel);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// Personel personel = getPersonelById(1).get();
		// personel.getDepartment().getPersonels().forEach(System.out::println);
		personelRepository.findByDepartmentName("Muhasebe").forEach(System.out::println);
	}

}
