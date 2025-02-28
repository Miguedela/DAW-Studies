package com.example.tema3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ejercicio4Controller {
    ArrayList<Anuncio> anuncios = new ArrayList<>();

    @ModelAttribute("anuncios")
    public List<Anuncio> getAnuncioList() {
        anuncios.add(new Anuncio("Juan", "Asunto de prueba 1", "Cuerpo de prueba 1"));
        anuncios.add(new Anuncio("Maria", "Asunto de prueba 2", "Cuerpo de prueba 2"));
        anuncios.add(new Anuncio("Beto", "Asunto de prueba 3", "Cuerpo de prueba 3"));

        return anuncios;
    }

    // Regirije a la página index
    @GetMapping("/ejercicio4")
    public String indexEjercicio4() {
        return "ejercicio4";
    }

    // Regirije a la página index
    @GetMapping("/formulario4")
    public String formularioEjercicio4() {
        return "ejercicio4formulario";
    }

    // Ejercicio 4
    @GetMapping("/anuncio4")
    public String aniadirAnuncioEjercicio4(
            @RequestParam("nombre") String nombre,
            @RequestParam("asunto") String asunto,
            @RequestParam("cuerpo") String cuerpo) {

        Anuncio anuncio = new Anuncio(nombre, asunto, cuerpo);

        anuncios.add(anuncio);

        return "ejercicio4";
    }
}
