package microservicios.controller;

import microservicios.domain.entities.Patient;
import microservicios.service.PatientService;
import microservicios.utility.BusinessException;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static  org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(PatientController.class)
class PatientControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean //permite generar simulatros de mockito
    private PatientService patientService;


    @Test
    void createPatient() throws Exception {
        Patient patient = new Patient(1L,"agost",8);

        String requestBody = "{ \"id\": 1, \"name\": \"agost\", \"age\": 8 }";
       var hola = when(patientService.crearPatient(patient)).thenReturn(patient);



        ResultActions resultActions = mockMvc.perform(post("/patient/create")
                .contentType(MediaType.APPLICATION_JSON).content(requestBody)
               );

        resultActions.andExpect(status().isCreated());

        verify(patientService).crearPatient(any());






    }
}