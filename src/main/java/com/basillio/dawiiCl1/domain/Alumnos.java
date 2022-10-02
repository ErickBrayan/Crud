package com.basillio.dawiiCl1.domain;


import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Data
@Entity
@Table(name = "TB_ALUMNOS")
public class Alumnos implements Serializable{
    
    private static final long serialIVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumno_id")
    private Integer idAlumno;
    
    @NotBlank(message = "Debe Ingresar su Nombre")
    private String nombre;
    
    @NotBlank(message = "Debe Ingresar su Apellido")
    private String apellido;
    
    @NotEmpty(message = "Debe Ingresar su Correo")
    @Email
    private String correo;
    
    
    @DateTimeFormat(iso = ISO.DATE)
    @Past
    @NotNull(message = "Debe Ingresar su Fecha de Nacimiento")
    @Column(name = "fecha_registro")
    private LocalDate fecReg;
    
    
}
