package hr.inovatrend.carservicelora.entity;

import hr.inovatrend.carservicelora.entity.enums.CarManufacturer;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_sequence")
    @SequenceGenerator(name = "car_sequence", allocationSize = 10)
    @Setter(AccessLevel.PRIVATE)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "klijentid")
    private User klijent;
    private CarManufacturer tip;
    private String godina;
    private String registracija;
    private String boja;

}
