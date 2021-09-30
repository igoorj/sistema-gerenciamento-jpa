package one.digitalinnovation.personapi.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true) // só aceita pessoas com cpf único
    private String cpf;

    private String birthDate;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,
                       CascadeType.MERGE,
                       CascadeType.REMOVE }
    ) // one person may have several numbers
    private List<Phone> phones;
}
