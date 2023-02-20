package microservicios.utility;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Response {
    public  Boolean error;
    public String message;

    public Object data;

    private LocalDateTime timestamp = LocalDateTime.now();
    public  Response (){
        error = false;
        message = "";
        data= null;

    }
    public  void restart(){
        error = false;
        message = "";
        data = null;
    }


}
