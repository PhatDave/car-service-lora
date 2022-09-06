package hr.inovatrend.carservicelora.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    @SequenceGenerator(name = "users_sequence", allocationSize = 10)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    private String OIB;
    private String name;
    private String surname;
    private String address;
}