package com.basillio.dawiiCl1.controller;

import com.basillio.dawiiCl1.domain.Alumnos;
import com.basillio.dawiiCl1.service.AlumnosService;
import lombok.experimental.PackagePrivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AlumnoController {

    @Autowired
    AlumnosService as;   
    

    @GetMapping("/nuevoAlumno")
    public String nuevoAlumno(Model model) {
        model.addAttribute("alumno", new Alumnos());
        return "nuevoAlumno";
    }

    @PostMapping("/nuevoAlumno")
    public String guardarAlumno(Alumnos alumnos, RedirectAttributes redirect, Model model) {
        as.guardarAlumno(alumnos);
        redirect.addFlashAttribute("msgCorrecto", "El Alumno se Agrego Exitosamente!!");
        return "redirect:/listaAlumnos";
    }
    
    @GetMapping("/{idporasignar}/editarAlumno")
    public String editarAlumno(@PathVariable Integer idporasignar, Model model) {
        /*Alumnos alumnos = ad.getById(idporasignar);
        model.addAttribute("alumno", alumnos);*/
        Alumnos alumnos = as.econtrarAlumnos(idporasignar);
        model.addAttribute("alumno", alumnos);
        return "nuevoAlumno";
    }
    
    @PostMapping("/{idporasignar}/editarAlumno")
    public String guardarCambiosAlumno(@PathVariable Integer idporasignar,Alumnos alumnos, RedirectAttributes redirect, Model model) {
        Alumnos al = as.econtrarAlumnos(idporasignar);        
        
        al.setNombre(alumnos.getNombre());
        al.setApellido(alumnos.getApellido());
        al.setCorreo(alumnos.getCorreo());
        al.setFecReg(alumnos.getFecReg());        
        
        as.guardarAlumno(al);
        redirect.addFlashAttribute("msgCorrecto", "El Alumno se Actualizo Exitosamente!!");
        return "redirect:/listaAlumnos";
    } 
    
    @GetMapping("/eliminarAlumno/{idporasignar}")
    public String eliminarAlumno(Model model,@PathVariable Integer idporasignar) {
        as.eliminarAlumno(idporasignar);
        return "redirect:/listaAlumnos";
    }
}
