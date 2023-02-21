package microservicios.repository;

import lombok.Data;
import microservicios.domain.entities.Patient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PatientRepositoryTest {
    @Autowired
    private PatientRepository patientRepository;


    @Test
    void buscarMenores() {


        int edadMaxima = 10;
        patientRepository.save(new Patient("agus", 11));
        patientRepository.save(new Patient( "arbol", 8));

        // When
        List<Patient> pacientes = patientRepository.buscarMenores();

        // Thensadasdsadsdsds
        assertThat(pacientes).extracting(patient -> patient.getAge()).allMatch(age -> age < edadMaxima);
        System.out.println(pacientes.toString());
    }
}
