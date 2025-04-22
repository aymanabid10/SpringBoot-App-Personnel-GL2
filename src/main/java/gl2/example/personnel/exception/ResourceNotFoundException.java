package gl2.example.personnel.exception;

//Custom Exception pour mettre nos propore message, qui sera injecté au message de ResponseApi DTO
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}