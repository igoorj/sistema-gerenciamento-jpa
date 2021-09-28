package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.*;

@Entity // define this class like a table on databasse
@Data // insert getters and setters
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY ) // auto increment command
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) // this value is obrigatory
    private PhoneType type;

    @Column(nullable = false) // this value is obrigatory
    private String number;
}
