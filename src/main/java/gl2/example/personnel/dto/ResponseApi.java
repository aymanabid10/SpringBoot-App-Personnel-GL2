package gl2.example.personnel.dto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseApi<T> {
    private boolean success;
    private String message;
    private T data;
}
