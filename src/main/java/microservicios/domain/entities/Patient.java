package microservicios.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "patient")
@AllArgsConstructor
@NoArgsConstructor
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

    public Patient(String name, Integer age) {
        this.id_patient = getId_patient();
        this.name = name;
        this.age = age;
    }
}
