package com.example.tema3;

// import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// @Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "valerom") String name,
            Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    // Regirije a la página index
    @GetMapping("")
    public String index() {
        return "index";
    }

    // Ejercicio 1
    @GetMapping("/mensaje")
    public String anuncio(@RequestParam(name = "name", required = false, defaultValue = "valerom") String name,
            Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}