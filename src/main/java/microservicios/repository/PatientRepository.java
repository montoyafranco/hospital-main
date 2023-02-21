package microservicios.repository;

import microservicios.domain.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository <Patient,Integer> {
    @Query("SELECT u FROM Patient u WHERE u.age < 10")
    List<Patient> buscarMenores();
}
