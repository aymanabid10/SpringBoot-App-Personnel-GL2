package gl2.example.personnel.service;
import gl2.example.personnel.dto.EmployeeRequest;
import gl2.example.personnel.dto.EmployeeResponse;
import gl2.example.personnel.exception.ResourceNotFoundException;
import gl2.example.personnel.mapper.EmployeeMapper;
import gl2.example.personnel.model.Employee;
import gl2.example.personnel.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//Handling du constructor avec @RequiredArgsConstructor
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    //enregistrer un Employee
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = employeeMapper.toEntity(employeeRequest);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toResponse(savedEmployee);
    }

    //Lister les personnels sous forme du DTO EmployeeResponse
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toResponse)
                .collect(Collectors.toList());
    }

    //Obtenir un Employee avec son Id
    public EmployeeResponse getEmployee(Long id) {
        Employee employee = this.getEmp(id);
        return employeeMapper.toResponse(employee);
    }
    //mettre a jour un Employee
    public EmployeeResponse updateEmployee(Long id, EmployeeRequest employeeRequest) {
        Employee existingEmployee = this.getEmp(id);
        employeeMapper.updateEntityFromRequest(employeeRequest, existingEmployee);
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return employeeMapper.toResponse(updatedEmployee);
    }
    //fonction génerique pour l'obtention d'un Employee qui est utilisée au differents méthodes
    private Employee getEmp(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
    }
    //Supprimer un Employee
    public void deleteEmployee(Long id) {
        Employee employee = this.getEmp(id); //cette ligne déclanche une exception et retoure un ResponseApi si Employee n'existe pas
        employeeRepository.deleteById(id);
    }
}
