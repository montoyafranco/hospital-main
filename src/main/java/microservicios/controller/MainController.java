package microservicios.controller;

import microservicios.utility.BusinessException;
import microservicios.utility.Response;
import microservicios.utility.RespuestaExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class MainController {

    protected RespuestaExceptionDTO getInternalErrorMessage(Exception exception){
        Response response = new Response();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        response.error = true;
        response.message = exception.getMessage();
        response.data = exception.getCause();
        return  new RespuestaExceptionDTO(response,httpStatus);
    }
    protected RespuestaExceptionDTO getErrorDeNegocioMessage(BusinessException businessException){
        Response response = new Response();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        response.error = true;
        response.message = businessException.getMessage();
        response.data = businessException.getCause();
        return new RespuestaExceptionDTO(response,httpStatus);

    }
    protected  Map<String, String> getErrorMap(BindingResult bindingResult) {
        Map<String, String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }

}
