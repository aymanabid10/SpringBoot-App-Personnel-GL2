package gl2.example.personnel;

import gl2.example.personnel.dto.ResponseApi;
import gl2.example.personnel.exception.ResourceNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class PersonnelApplication {

	public static void main(String[] args) {

		SpringApplication.run(PersonnelApplication.class, args);
	}

    @ControllerAdvice
    public static class GlobalExceptionHandler {

        @ExceptionHandler(MethodArgumentNotValidException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public ResponseApi<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
            Map<String, String> errors = new HashMap<>();
            ex.getBindingResult().getAllErrors().forEach(error -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });

            return new ResponseApi<>(false, "Validation errors", errors);
        }

        @ExceptionHandler(DataIntegrityViolationException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public ResponseApi<String> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
            String errorMessage = "Database constraint violation: " + ex.getMostSpecificCause().getMessage();
            return new ResponseApi<>(false, errorMessage, null);
        }

        @ExceptionHandler(Exception.class)
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        public ResponseApi<String> handleGenericException(Exception ex) {
            return new ResponseApi<>(false, "Internal server error: " + ex.getMessage(), null);
        }

        @ExceptionHandler(ResourceNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public ResponseApi<String> handleResourceNotFound(ResourceNotFoundException ex) {
            return new ResponseApi<>(false, ex.getMessage(), null);
        }
    }
}
