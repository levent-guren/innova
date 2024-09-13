package tr.com.innova.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.com.innova.entity.Personel;

public interface PersonelRepository extends JpaRepository<Personel, Integer> {
	List<Personel> findByNameContaining(String name);

	// @Query(value = "from Personel p where p.department.name= :name")
	List<Personel> findByDepartmentName(String name);

}
