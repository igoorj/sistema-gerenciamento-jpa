package one.digitalinnovation.personapi.repository;

import one.digitalinnovation.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/*
======================================================================================
* JpaRepository needs the type of objective entity and the value that will go validate
======================================================================================
* */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
