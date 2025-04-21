package gl2.example.personnel.mapper;


import gl2.example.personnel.dto.EmployeeRequest;
import gl2.example.personnel.dto.EmployeeResponse;
import gl2.example.personnel.model.Employee;
import org.mapstruct.*;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {

    Employee toEntity(EmployeeRequest employeeRequest);

    EmployeeResponse toResponse(Employee employee);

    void updateEntityFromRequest(EmployeeRequest employeeRequest, @MappingTarget Employee employee);
}
