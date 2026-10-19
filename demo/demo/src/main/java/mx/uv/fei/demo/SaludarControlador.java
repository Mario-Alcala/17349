package mx.uv.fei.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class SaludarControlador {
    String nombre;
    
    // CORRECCIÓN 1: Declaramos la variable global, pero NO la instanciamos aquí
    // para evitar el error del constructor vacío.
    Saludador saludador;   

    @GetMapping("/saludos")
    public String saludar() {
        return "Hola, mundo!" + nombre;  
    }

    @GetMapping("/despedidas")
    public String adios() {
        return "Adiós, mundo!";
    }

    @PostMapping("/nombramientos")
    public void nombre() {
        nombre = "Roa";
    }

    // Actualizar el nombre
    @PutMapping("/nombramientos")
    public void met1() {
        nombre = "Alessandro";
    }

    // Eliminar el nombre  
    @DeleteMapping("/nombramientos")
    public void met2() {
        nombre = null;  
    }       

    @GetMapping("/saludos/{nombre}")
    public Saludador met3(@PathVariable String nombre) {
        System.out.println(nombre);
        return new Saludador(nombre);
    }

    @GetMapping("/saludos2/{nombrex}")
    public Saludador met4(@PathVariable("nombrex") String nombre) {
        System.out.println(nombre);
        return new Saludador(nombre);
    }

    @PostMapping("/crearSaludador")
    public String crearSaludador(@RequestBody Saludador objetoSaludador) {
        // Asignamos el objeto recibido de forma segura a nuestra variable global
        this.saludador = objetoSaludador;
        // CORRECCIÓN 2: Accedemos al contenido real usando el método que creaste en la clase Saludador
        return "Saludador creado con éxito: " + objetoSaludador.getContenido();
    }

    @PostMapping("/obtenerSaludador")
    public Saludador obtenerSaludador(@RequestBody String nombre) {
        return new Saludador(nombre);
    }

    //agregar metodo que mapee raiz
    @RequestMapping("/")
    public String raiz() {
    String contenido = null;
    contenido = """
    <h1>Menu de opciones</h1>
    <ul>
        <li><a href="/saludos">Saludar</a></li>
        <li><a href="/despedidas">Despedirse</a></li>
        <li><a href="/nombramientos">Nombrar</a></li>
        <li><a href="/saludos/{nombre}">Saludar con nombre</a></li>
        <li><a href="/saludos2/{nombrex}">Saludar con nombrex</a></li>
        <li><a href="/crearSaludador/{nombre}">Crear Saludador</a></li>
        <li><a href="/obtenerSaludador">/saludar/{nombre}">Obtener Saludador</a></li>

    """;
    return contenido;
    }

    @GetMapping("/query1")
    public String query1(@RequestParam String nombre,
        @RequestParam String paterno,
        @RequestParam(defaultValue = "")String materno){
             System.out.printline(nombre);
             return nombre + " " + paterno + " " + materno;
    }
}