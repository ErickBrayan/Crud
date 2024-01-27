package com.basillio.dawiiCl1;

import com.basillio.dawiiCl1.domain.Cursos;
import com.basillio.dawiiCl1.service.CursosService;
import java.time.LocalDate;
import java.time.Month;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DawiiCl1Application implements CommandLineRunner {

    @Autowired
    CursosService cs;

    public static void main(String[] args) {
        SpringApplication.run(DawiiCl1Application.class, args);
        System.out.println("Listo");
    }

    @Override
    public void run(String... args) throws Exception {
        
        //List<Alumnos> lista = (List<Alumnos>) as.listarAlumnos();

        //lista.forEach(System.out::println); 
        
        Cursos c = new Cursos();
        c.setNombre("Comu");
        c.setProfesor("Ramirez");
        c.setSeccion("CB2R");
        c.setFecReg(LocalDate.of(2022, Month.MARCH, 12));
        
        //cs.guardarCurso(c);
        

    }

}
