package microservicios.utility;

import microservicios.domain.entities.Patient;

public class BusinessException extends Exception{

    public BusinessException(String message) {
        super(message);



    }
}
