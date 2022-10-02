package com.basillio.dawiiCl1.service;

import com.basillio.dawiiCl1.domain.Cursos;
import java.util.List;

public interface CursosService {
    
    public List<Cursos> listarCursos();
    
    public void guardarCurso(Cursos cursos);
    
    public void eliminarCurso(Cursos cursos);
    
    public Cursos econtrarCurso(Integer id);    
    
    
}
