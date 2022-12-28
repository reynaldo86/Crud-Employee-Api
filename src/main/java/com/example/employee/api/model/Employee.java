package com.example.employee.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_employee")
public class Employee implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false, length = 50)
    private String age;
    @Column(nullable = false, length = 50)
    private String sexo;
    @Email
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false, length = 50)
    private LocalDateTime registrationDate;

}
