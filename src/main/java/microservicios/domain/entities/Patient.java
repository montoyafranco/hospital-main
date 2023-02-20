package microservicios.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patient", nullable = false)
    private Long id_patient;

    @NotBlank
    @Size(min = 2)
    private String name;
    @NotNull
    @Min(1)

    private Integer age;


}
