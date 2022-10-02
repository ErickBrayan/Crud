package com.basillio.dawiiCl1.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Data
@Entity
@Table(name = "TB_CURSOS")
public class Cursos implements Serializable{
    
    private static final long serialIVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cursoid")
    private Integer idCurso;
    private String nombre;
    private String profesor;
    private String seccion;
    
    
    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "fecha_registro")
    private LocalDate fecReg;
     
}
