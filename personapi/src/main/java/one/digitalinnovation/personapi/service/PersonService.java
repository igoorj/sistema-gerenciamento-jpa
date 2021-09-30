package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;
//import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

/*
*
* Classe Responsável por manter as regras de negócio da aplicação
* Será a responsável por interagir com o banco de dados, logo é necessario usar PersonRepository como injeção
* de dependências
* */

@Service
public class PersonService {

    private PersonRepository personRepository;

    //private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople;
    }

    public Person findById(Long id) throws PersonNotFoundException{

        Person person = verifyIfExists(id);
        return person;
    }


    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        //Person personToSave = personMapper.toModel(personDTO);
        Person personToSave = Person.builder()
                .firstName(personDTO.getFirstName())
                .lastName(personDTO.getLastName())
                .birthDate(personDTO.getBirthDate())
                .cpf(personDTO.getCpf())
                .phones(personDTO.getPhones())
                .build();


        /* Retorna um objeto similar ao que foi salvo no banco */
        Person personSaved = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created with success! Id " +personSaved.getId())
                .build();
    }

    public void deleteById(Long id) throws PersonNotFoundException{

        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

}
