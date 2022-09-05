package hr.inovatrend.carservicelora.entity;

import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
	@SequenceGenerator(name = "users_sequence", allocationSize = 10)
	@Setter(AccessLevel.PRIVATE)
	private Long id;

	private String name;
	private String surname;
}
