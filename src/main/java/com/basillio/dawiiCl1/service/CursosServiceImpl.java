package com.basillio.dawiiCl1.service;

import com.basillio.dawiiCl1.dao.CursosDao;
import com.basillio.dawiiCl1.domain.Cursos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursosServiceImpl implements CursosService{
    
    @Autowired
    CursosDao cdao;

    @Override
    public List<Cursos> listarCursos() {
        return (List<Cursos>) cdao.findAll();
    }

    @Override
    public void guardarCurso(Cursos cursos) {
        cdao.save(cursos);
    }

    @Override
    public void eliminarCurso(Cursos cursos) {
        cdao.delete(cursos);
    }

    @Override
    public Cursos econtrarCurso(Integer id) {
        return cdao.findById(id).get();
        
    }
    
}
