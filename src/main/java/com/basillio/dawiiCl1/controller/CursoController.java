package com.basillio.dawiiCl1.controller;

import com.basillio.dawiiCl1.domain.Cursos;
import com.basillio.dawiiCl1.service.CursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CursoController {
    
    @Autowired
    CursosService cs;
    
    @GetMapping("/nuevoCurso")
    public String nuevoAlumno(Model model){
        model.addAttribute("curso",new Cursos());
        return "nuevoCursos";
    }
    
    @PostMapping("/nuevoCurso")
    public String guardarAlumno(Cursos cursos,RedirectAttributes redirect,Model model){
              
        cs.guardarCurso(cursos);
        redirect.addFlashAttribute("msgCorrecto","El Curso se Agrego Exitosamente!!");
        return "redirect:/listaCursos";
    }   
    
    
    @GetMapping("/{idCurso}/editarCurso")
    public String editarCurso( Integer id, Model model){
        Cursos curso = cs.econtrarCurso(id);
        model.addAttribute("curso",curso);
        return "nuevoCursos";
    }
    
    @PostMapping("/{idCurso}/editarCurso")
    public String modificarAlumno( Integer id,Cursos cursos,RedirectAttributes redirect,Model model){
              
        Cursos curso2 = cs.econtrarCurso(id);
        
        curso2.setIdCurso(id);
        curso2.setNombre(curso2.getNombre());
        curso2.setProfesor(curso2.getProfesor());
        curso2.setSeccion(curso2.getSeccion());
        curso2.setFecReg(curso2.getFecReg());
        
        cs.guardarCurso(curso2);
        redirect.addFlashAttribute("msgCorrecto","El Curso !!");
        return "redirect:/listaCursos";
    }
    
    @PostMapping("/{idCurso}/eliminarCurso")
    public String eliminarAlumno(Integer id, RedirectAttributes redirect){
        Cursos curso = cs.econtrarCurso(id);
        cs.eliminarCurso(curso);
        redirect.addFlashAttribute("msgCorrecto","El Curso se elimino!!");
        return "redirect:/listaCursos";
    }
}
