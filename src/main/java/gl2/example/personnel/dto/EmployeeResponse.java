package gl2.example.personnel.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

//le DTO pour les reponses de l'API qui communique avec le modèle Employee a traversEmployeeMapper
@Data // génerer les getters et les setters avec Lombok + le code devient plus clair
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeResponse {
    @Schema(description = "Unique ID of the employee", example = "1")
    private Long id;

    @Schema(description = "Employee's first name", example = "Aymen")
    private String firstName;

    @Schema(description = "Employee's first name", example = "Abid")
    private String lastName;

    @Schema(description = "Employee's email address", example = "Aymen.Abid@example.com")
    private String email;
}
