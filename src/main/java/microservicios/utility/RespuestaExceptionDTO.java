package microservicios.utility;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class RespuestaExceptionDTO {
    private Response response;
    private HttpStatus httpStatus;

    public RespuestaExceptionDTO(Response response, HttpStatus httpStatus) {
        this.response = response;
        this.httpStatus = httpStatus;
    }
}
