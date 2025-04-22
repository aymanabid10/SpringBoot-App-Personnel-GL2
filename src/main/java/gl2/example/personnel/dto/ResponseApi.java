package gl2.example.personnel.dto;
import lombok.*;

//Le DTO pour gérer les réponses de l'API + personnaliser les réponses de la API avec les Global Exceptions
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseApi<T> {
    //code de Response
    private boolean success;
    //message de l'opération
    private String message;
    // les données affectés
    private T data;
}
