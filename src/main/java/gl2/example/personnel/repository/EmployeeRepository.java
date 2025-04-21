package gl2.example.personnel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import gl2.example.personnel.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
