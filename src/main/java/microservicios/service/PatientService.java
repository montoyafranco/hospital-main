package microservicios.service;

import microservicios.domain.entities.Patient;
import microservicios.repository.PatientRepository;
import microservicios.utility.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
}
