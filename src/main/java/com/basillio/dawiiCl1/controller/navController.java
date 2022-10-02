package com.basillio.dawiiCl1.controller;

import com.basillio.dawiiCl1.domain.Alumnos;
import com.basillio.dawiiCl1.domain.Cursos;
import com.basillio.dawiiCl1.service.AlumnosService;
import com.basillio.dawiiCl1.service.CursosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class navController { 
    
    @Autowired
    AlumnosService as;
    
    @Autowired
    CursosService cs;

    @GetMapping({"/",""})
    public String paginaInicio(){
        
        return "index";
    }
    
    @GetMapping("/listaAlumnos")
    public String mantenimientoAlumnos(Model model){
        List<Alumnos> listaalumnos = as.listarAlumnos();
        model.addAttribute("listaalumnos",listaalumnos);
        return "MantenimientoAlumnos";
    }   
    
    
    @GetMapping("/listaCursos")
    public String mantenimientoCursos(Model model){
        
        List<Cursos> listaCursos = cs.listarCursos();
        model.addAttribute("listacursos", listaCursos);

        
        return "ManteniemientoCursos";
    }
}
