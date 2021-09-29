package one.digitalinnovation.personapi.mapper;

import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.request.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/*
* Classse responsável por fazer a conversão de um objeto DTO em um objeto comum,
* respeitando as exigências e na hora de instanciar um novo objeto do tipo Person
* */

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    /*
    * Converte um objeto DTO para um objeto do banco de dados
    * */
    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);


    PersonDTO toDTO(Person person);
}
