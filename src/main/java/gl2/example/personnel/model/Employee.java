package gl2.example.personnel.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data //@Getter + @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="email", nullable = false)
    private String email;

    public void updateDetailsFrom(Employee updated) {
        this.firstName = updated.getFirstName();
        this.lastName = updated.getLastName();
        this.email = updated.getEmail();
    }

}
