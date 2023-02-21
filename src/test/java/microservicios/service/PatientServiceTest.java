package microservicios.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PatientServiceTest {

    @Test
    void crearPatient() {
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


