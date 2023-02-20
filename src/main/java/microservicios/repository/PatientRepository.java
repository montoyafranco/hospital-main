package microservicios.repository;

import microservicios.domain.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository <Patient,Integer> {
}
