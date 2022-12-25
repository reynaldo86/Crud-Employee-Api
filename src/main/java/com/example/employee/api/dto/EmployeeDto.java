package com.example.employee.api.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmployeeDto {
    @NotBlank
    private String name;
    @NotBlank
    private String age;
    @NotBlank
    private String sexo;
    @NotBlank
    private String office;
}
