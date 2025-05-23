package gl2.example.personnel.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


//definition des DTOs
//le DTO pour les requetes qui communique avec le modèle Employee a traversEmployeeMapper
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequest {
    @NotBlank(message = "First name is mandatory")
    //@Schema pour définir les exemples pour la documentation Swagger :
    @Schema(description = "Employee's first name", example = "Aymen")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Schema(description = "Employee's last name", example = "Abid")
    private String lastName;

    @NotBlank(message = "email is mandatory")
    @Schema(description = "Employee's email address", example = "aymen.abid@example.com")
    private String email;
}
