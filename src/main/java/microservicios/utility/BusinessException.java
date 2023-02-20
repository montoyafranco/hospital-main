package microservicios.utility;

import microservicios.domain.entities.Patient;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class BusinessException extends Exception{


    public BusinessException(String message) {
        super(message);




    }
}
