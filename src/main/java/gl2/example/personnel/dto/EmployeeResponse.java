package gl2.example.personnel.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
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
