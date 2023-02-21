package microservicios.service;

import lombok.AllArgsConstructor;
import microservicios.domain.entities.Patient;
import microservicios.repository.PatientRepository;
import microservicios.utility.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientService {


    @Autowired
    private PatientRepository patientRepository;



    public Patient crearPatient(Patient patient) throws BusinessException {
        if (patient.getAge() > 10){
            throw new BusinessException("El pibardo es mayor de edad" + " " + patient.toString() );
        }
        Patient response = patientRepository.save(patient);
        return response;
    }
    public List<Patient> getAllPatients() throws BusinessException {

        List<Patient> response = patientRepository.findAll();
        return response;
    }
}
