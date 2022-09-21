package hr.inovatrend.carservicelora.entity;

import hr.inovatrend.carservicelora.entity.User;
import hr.inovatrend.carservicelora.entity.enums.CarManufacturer;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name = "services")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_sequence")
    @SequenceGenerator(name = "service_sequence", allocationSize = 10)
    @Setter(AccessLevel.PRIVATE)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "carid")
    private Car auto;


    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private String datetime;
    private float price;
    private String description;
    private String workerName;
    private String workerLName;

}
