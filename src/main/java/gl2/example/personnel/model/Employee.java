package gl2.example.personnel.model;

import jakarta.persistence.*;
import lombok.*;

//En utilise @Data pour génerer les getters, setters, toString, ...
//@NoArgsConstructor et @AllArgsConstructor pour les beans aussi pour le mapper qui fera le parsing du constructeur
@Entity
@Data //@Getter + @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

}
