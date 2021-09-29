
package one.digitalinnovation.personapi.repository;

import one.digitalinnovation.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/*
*
* Essa interface implementa uma classe do tipo Generics chamada JpaRepository que recebe
* como parâmetros a Entidade que será gerenciada e o tipo do atributo Id, no caso, Long.
*
* Essa interface fornece todas as principais query's necessárias para interagir com o banco de dados
* não sendo necessário nenhum tipo de controle propriamente dito
*
* */

public interface PersonRepository extends JpaRepository<Person, Long> {

}
