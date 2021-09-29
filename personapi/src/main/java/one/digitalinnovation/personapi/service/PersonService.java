package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/*
*
* Classe Responsável por manter as regras de negócio da aplicação
* Será a responsável por interagir com o banco de dados, logo é necessario usar PersonRepository como injeção
* de dependências
* */

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // add method

    public MessageResponseDTO createPerson(Person person) {

        /* Retorna um objeto similar ao que foi salvo no banco */
        Person personSaved = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created with success! Id " +personSaved.getId())
                .build();
    }
}
