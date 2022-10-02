package com.basillio.dawiiCl1.service;

import com.basillio.dawiiCl1.dao.AlumnosDao;
import com.basillio.dawiiCl1.domain.Alumnos;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnosServiceImpl implements AlumnosService{
    
    @Autowired
    AlumnosDao adao;

    @Override
    @Transactional(readOnly = true)
    public List<Alumnos> listarAlumnos() {
        return (List<Alumnos>) adao.findAll();
    }

    @Override
    @Transactional
    public void guardarAlumno(Alumnos alumnos) {
        adao.save(alumnos);
    }

    @Override
    @Transactional
    public void eliminarAlumno(Integer id) {
        adao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Alumnos econtrarAlumnos(Integer id) {           
        return adao.findById(id).orElseThrow();
    }
    
}
