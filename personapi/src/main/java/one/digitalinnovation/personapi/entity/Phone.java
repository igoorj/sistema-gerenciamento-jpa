package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY ) // auto increment command
    private Long id;

    @Enumerated(EnumType.STRING) // definindo o tipo do conteudo como de acordo com do arquivo PhoneType
    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false)
    private String number;
}
