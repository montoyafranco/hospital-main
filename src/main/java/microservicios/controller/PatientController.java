package microservicios.controller;

import microservicios.domain.entities.Patient;
import microservicios.service.PatientService;
import microservicios.utility.BusinessException;
import microservicios.utility.Response;
import microservicios.utility.RespuestaExceptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("patient")
@CrossOrigin(origins = "*")
public class PatientController {
    @Autowired
    private MainController mainController;

    @Autowired
    private PatientService patientService;

    private Response response = new Response();
    private HttpStatus httpStatus = HttpStatus.OK;

    @PostMapping("create")
    public ResponseEntity<Response> createPatient(@RequestBody @Validated Patient patient, BindingResult bindingResult) {
        response.restart();
        if (bindingResult.hasErrors()) {
            Map errorMap = mainController.getErrorMap(bindingResult);

            response.error = true;
            response.data = errorMap;
            response.message = "Errores de Validator";
            httpStatus = HttpStatus.BAD_REQUEST;

        } else {
            try {
                Patient respuesta = patientService.crearPatient(patient);
                response.data = respuesta;
                response.message = "Exitosamente creado";
                httpStatus = HttpStatus.CREATED;

            } catch (BusinessException e) {
                RespuestaExceptionDTO respuestaExceptionDTO = mainController.getErrorDeNegocioMessage(e);
                response = respuestaExceptionDTO.getResponse();
                httpStatus = respuestaExceptionDTO.getHttpStatus();

            } catch (Exception e) {
                RespuestaExceptionDTO respuestaExceptionDTO = mainController.getInternalErrorMessage(e);
                response = respuestaExceptionDTO.getResponse();
                httpStatus = respuestaExceptionDTO.getHttpStatus();

            }
        }
        return new ResponseEntity<>(response, httpStatus);
    }


}
