package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import one.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/people/")
public class PersonController {

    /*
     *
     * injetando a dependencia da classe Service que vai ser a responsável pelas regras de negócio
     * */
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /*
    *
    * @RequestBody: Informa ao metodo que será passado um objeto do tipo Person através de uma requisição
    * - Aqui é utilizado a classe MessageResponseDTO como uma instancia a ser retornada
    * */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }
}
