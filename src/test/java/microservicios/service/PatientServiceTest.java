package microservicios.service;

import microservicios.domain.entities.Patient;
import microservicios.repository.PatientRepository;
import microservicios.utility.BusinessException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

    @Mock
    private PatientRepository repository;
    private PatientService patientServiceTest;



    @BeforeEach
    void setUp(){

        patientServiceTest = new PatientService(repository);
    }

    @Test
    void crearPatientOK() {
        //given
        Patient patient = new Patient("Agus",9);

        //when
        repository.save(patient);

        //then
        ArgumentCaptor<Patient> patientArgumentCaptor = ArgumentCaptor.forClass(Patient.class);

        verify(repository).save(patientArgumentCaptor.capture());

        Patient value = patientArgumentCaptor.getValue(); //capturo los argumentos que pasaron por repositorio

        assertThat(value).isEqualTo(patient); // aseguro que los argumentos pasados son iguales a los creados



        verify(repository).save(any());//aseguro que algo se guardo



    }
    @Test
    @DisplayName("Error de pibardo es mayor de edad")
    void crearPatientError() throws BusinessException {
        //given
        Patient patient = new Patient("Agus",11);

//        patientServiceTest.crearPatient(patient);

        assertThatThrownBy(() -> patientServiceTest.crearPatient(patient) )
                .isInstanceOf(BusinessException.class)
                .hasMessageContaining("El pibardo es mayor de edad" + " " + patient.toString());

        verify(repository, never()).save(any());







    }
    @Test
    void getAllPatients() throws BusinessException {
        //when utilizo la funcion getallpatints de servicio
       patientServiceTest.getAllPatients();

       //verify aca verifico si el repositorio se invoco y uso el findall
        verify(repository).findAll();

    }


    @Test
    void numeros() {
        //arrange given
        int n1 = 5;
        int n2 = 30;
        //when ,appliy

        Calcular resul = new Calcular();
        int resultado = resul.add(n1, n2);

        //then
        assertThat(resultado).isEqualTo(35);


    }



    class Calcular {
        int add(int a, int b) {
            return a + b;
        }
    }

}


