package gl2.example.personnel.mapper;


import gl2.example.personnel.dto.EmployeeRequest;
import gl2.example.personnel.dto.EmployeeResponse;
import gl2.example.personnel.model.Employee;
import org.mapstruct.*;

//Créer un Mapper avec mapStruct pour faire le parsing et le setting des Données entre les DTOs et le modèle
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {
    //Transformer un EmployeeRequest vers Employee
    Employee toEntity(EmployeeRequest employeeRequest);

    //Transformer un EmployeeResponse vers Employee
    EmployeeResponse toResponse(Employee employee);

    //mettre à jour le modèle Employee à partir de Employee
    void updateEntityFromRequest(EmployeeRequest employeeRequest, @MappingTarget Employee employee);
}
