package com.example.tema3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ejercicio1Controller {

    // Regirije a la página index del ejercicio1
    @GetMapping("/ejercicio1")
    public String indexEjercicio1() {
        return "ejercicio1formulario";
    }

    // Formulario del ejercicio 1
    @GetMapping("/anuncio")
    public String anuncioEjercicio2(
            @RequestParam("nombre") String nombre,
            @RequestParam("asunto") String asunto,
            @RequestParam("cuerpo") String cuerpo,
            Model model) {

        Anuncio anuncio = new Anuncio(nombre, asunto, cuerpo);

        model.addAttribute("anuncio", anuncio);

        return "ejercicio1anuncio";
    }
}
