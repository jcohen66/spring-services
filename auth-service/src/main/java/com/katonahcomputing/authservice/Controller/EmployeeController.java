package com.katonahcomputing.authservice.Controller;

import com.katonahcomputing.authservice.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeController() {
        this.employees.add(new Employee("me@you.com", "Jon"));
    }

    @GetMapping("/employee")
    @ResponseBody
    public Optional<Employee> getEmployeeParam(@RequestParam String email, Principal userPrincipal) {

        return employees.stream()
                .filter(x -> x.getEmail().equals(email)).findAny();
    }

    @GetMapping("/employee/{email}")
    @ResponseBody
    public Optional<Employee> getEmployeePath(@PathVariable String email) {
        return employees.stream()
                .filter(x -> x.getEmail().equals(email)).findAny();
    }

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public void postMessage(@RequestBody Employee employee) {
        employees.add(employee);
    }
}
