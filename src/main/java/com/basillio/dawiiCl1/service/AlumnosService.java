package com.basillio.dawiiCl1.service;

import com.basillio.dawiiCl1.domain.Alumnos;

import java.util.List;


public interface AlumnosService {
    
    public List<Alumnos> listarAlumnos();
    
    public void guardarAlumno(Alumnos alumnos);
    
    public void eliminarAlumno(Integer id);
    
    public Alumnos econtrarAlumnos(Integer id);
    
    
}
