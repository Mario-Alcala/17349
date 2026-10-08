package mx.uv.fei.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class SaludarControlador {

    String nombre = "";

    @GetMapping("/saludos")
    public  String saludar(){
        return "Hola mundo!" + nombre;
    }

    @GetMapping("/despedidas")
    public String adios(){
        return "Adios mundo!";
    }

    //nombramiento
    @PostMapping("/nombramientos")
    public void nombre(){
        nombre = "mario";
    }

    //renombramiento
    @PutMapping("/nombramientos")
    public void met1(){
        nombre = "Mario J.";
    }

    //desnombramiento
    @DeleteMapping("/nombramientos")
    public void met2(){
        nombre = " ";
    }
}