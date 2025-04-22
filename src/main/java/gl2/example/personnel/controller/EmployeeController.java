package gl2.example.personnel.controller;

import gl2.example.personnel.dto.ResponseApi;
import gl2.example.personnel.dto.EmployeeRequest;
import gl2.example.personnel.dto.EmployeeResponse;
import gl2.example.personnel.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //Status de la request si elle est executée avec succées
    @Operation(summary = "Create a new employee", description = "Add a new employee to the system")
    //La Dcoumentation de Swagger pour indiquer les codes de ResponseApi possible
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Employee created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    //@Valid pour le parsing des exceptions globales
    public ResponseEntity<ResponseApi<EmployeeResponse>> createEmployee(@Valid @RequestBody EmployeeRequest employeeRequest){
        return new ResponseEntity<>(
                new ResponseApi<>(true, "Employee created", employeeService.createEmployee(employeeRequest)), HttpStatus.CREATED
        );
    }

    @GetMapping
    //La Dcoumentation de Swagger pour indiquer les codes de ResponseApi possible + description de l'endpoint et la méthode
    @Operation(summary = "Getting all employees", description = "Get a list of all employees")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<EmployeeResponse> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get employee by ID", description = "Retrieve an employee by their ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Employee found"),
            @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    public EmployeeResponse getEmployee(@PathVariable("id") Long id){
        return employeeService.getEmployee(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update employee details", description = "Update an existing employee's information")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Employee updated"),
            @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    public ResponseEntity<ResponseApi<EmployeeResponse>> updateEmployee(@PathVariable("id") Long id, @Valid @RequestBody EmployeeRequest employee){
        EmployeeResponse updated = employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(
                new ResponseApi<>(true, "Employee updated successfully", updated),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an employee", description = "Remove an employee from the system")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Employee deleted"),
            @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseApi<Void> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseApi<>(true, "Employee deleted successfully", null);
    }


}
