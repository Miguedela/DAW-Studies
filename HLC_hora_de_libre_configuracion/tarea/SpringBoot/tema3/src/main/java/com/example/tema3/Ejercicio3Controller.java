package com.example.tema3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ejercicio3Controller {

    @GetMapping("/ejercicio3")
    public String indexEjercicio3() {
        return "ejercicio3";
    }

    @GetMapping("/plantilla")
    public String enlacesEjercicio3(@RequestParam(name = "nenlace") String nenlace, Model model) {
        model.addAttribute("nenlace", nenlace);
        return "ejercicio3plantilla";
    }
}
