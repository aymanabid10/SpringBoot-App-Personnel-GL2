package gl2.example.personnel.exception;

import gl2.example.personnel.dto.ResponseApi;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
//Global Exception Handler pour gérer les exceptions et les responses des endpoints et mieux gérer les uri qui n'existe pas en utilisant le DTO ResponseApi
@RestControllerAdvice //on définit avec @RestcontrollerAdvice pour gérer les exceptions pour tout les @RestController à l'application et on fait parsing par @Valid pour activer les excpetions globales
public class GlobalExceptionHandler {
    //Gérer les BadRequests de l'application
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
    //Gérer les BadRequests si l'integrité des données données au body ne correspond pas aux DTOs du personnel
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        return Map.of("error", "Database constraint violation: " + ex.getMostSpecificCause().getMessage());
    }

    //Gérer les exceptions pour les endpoints qui n'existe pas
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseApi<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return new ResponseApi<>(false, ex.getMessage(), null);
    }

    //Gérer les exceptions pour les INTERNAL_SERVER_ERROR
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseApi<String> handleGenericException(Exception ex) {
        return new ResponseApi<>(false, "Internal server error: " + ex.getMessage(), null);
    }

}
