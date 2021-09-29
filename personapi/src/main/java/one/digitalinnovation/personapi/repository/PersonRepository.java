package one.digitalinnovation.personapi.repository;

import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.request.PersonDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
