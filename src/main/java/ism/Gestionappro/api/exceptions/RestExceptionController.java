package ism.Gestionappro.api.exceptions;

import org.codehaus.groovy.util.ListHashMap;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class RestExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> ObjectNotFoundException(
            Exception ex, WebRequest request
    ){
        Map<String,Object> body=new ListHashMap<>();
        body.put("statut", HttpStatus.NOT_FOUND.value());
        body.put("message",ex.getMessage());
        return new ResponseEntity(body, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NoDataException.class)
    public ResponseEntity<Object> ObjectNoDataException(
            Exception ex, WebRequest request
    ){
        Map<String,Object> body=new ListHashMap<>();
        body.put("statut",HttpStatus.NOT_FOUND.value());
        body.put("message",ex.getMessage());
        return new ResponseEntity(body, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String,Object> body=new ListHashMap<>();
        body.put("statut",HttpStatus.NOT_FOUND.value());
        body.put("message",ex.getMessage());
        return new ResponseEntity(body, HttpStatus.NOT_FOUND);
    }
}
