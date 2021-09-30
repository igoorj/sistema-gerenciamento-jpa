//
//package one.digitalinnovation.personapi.mapper;
//
//import one.digitalinnovation.personapi.dto.request.PersonDTO;
//import one.digitalinnovation.personapi.entity.Person;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//
//@Mapper
//public interface PersonMapper {
//
//    /*
//    *
//    * - Interface responsável por fazer a conversão de um objeto do tipo DTO em um objeto do tipo Entity
//    * - Esse metodo evita de ter de fazer as conversões manualmente
//    * */
//
//
//    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
//
//    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
//    Person toModel(PersonDTO personDTO);
//
//    PersonDTO toDTO(Person person);
//}
