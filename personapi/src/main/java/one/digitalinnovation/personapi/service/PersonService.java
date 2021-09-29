package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.repository.PersonRepository;
import one.digitalinnovation.personapi.request.PersonDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// esse metodo define as regras de negócio do projeto
// realiza as validações
@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        /*
        *  A partir de uma instância de PersonMapper, é passado como argumento, um objeto do
        * tipo PersonDTO, que será convertido em um objeto do tipo Person através do metodo
        * .toModel definido em PersonMapper
        * */
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created Person: " +savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        /* Convertendo o retorno do metodo findAll para uma lista de objetos do tipo DTO*/
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    /* Recuperando um usuario por seu id */

    public PersonDTO findById(Long id) throws PersonNotFoundException{

        Person person = verifyExists(id);
        return personMapper.toDTO(person);
    }

    /* Deletando um usuário */

    public void delete(Long id) throws PersonNotFoundException {

        verifyExists(id);
        personRepository.deleteById(id);
    }

    /* Metodo de verificação de existencia de um usuario */

    public Person verifyExists(Long id) throws PersonNotFoundException {

        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    /* Metodo de atualizar usuario */

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {

        verifyExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);

        Person personToSabe = personRepository.save(personToUpdate);
        return MessageResponseDTO
                .builder()
                .message("Updated Person with success!")
                .build();
    }
}
