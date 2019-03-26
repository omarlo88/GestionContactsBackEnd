package omar.lo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import omar.lo.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{


	@Query("select c from Contact c where c.nom like :x Order By c.nom DESC")
	public Page<Contact> chercher(@Param("x") String motCle, Pageable page);
}// ContactRepository
