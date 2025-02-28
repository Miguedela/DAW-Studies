package com.example.agriario;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AgriarioController {

        public static ArrayList<Tractor> tractores = new ArrayList<>();

        // INDEX
        @GetMapping("/index")
        public String verIndex(Model model) {
                // Si la lista ya tiene datos, no los agrega de nuevo
                if (tractores.isEmpty()) {
                        tractores.add(new Tractor("JD001", "Tractor de prueba 1", 11590,
                                        "https://res.cloudinary.com/dimees8ao/image/upload/v1738326546/tractor3_pjgsgn.jpg",
                                        "Descripción del tractor de prueba 1", 5));
                        tractores.add(new Tractor("JD002", "Tractor de prueba 2", 15580.99,
                                        "https://res.cloudinary.com/dimees8ao/image/upload/v1738326546/tractor5_sch911.jpg",
                                        "Descripción del tractor de prueba 2", 3));
                        tractores.add(new Tractor("JD003", "Tractor de prueba 3", 20000,
                                        "https://res.cloudinary.com/dimees8ao/image/upload/v1738326546/tractor2_tzgldl.jpg",
                                        "Descripción del tractor de prueba 3", 9));
                }

                // Pasar la lista de tractores al modelo
                model.addAttribute("tractores", tractores);
                return "index";
        }

        // DETALLES
        @GetMapping("/detalles/{id}")
        public String verDetalles(@PathVariable("id") String id, Model model) {
                // Buscar el tractor por su ID
                for (Tractor tractor : tractores) {
                        if (tractor.getCode().equals(id)) {
                                model.addAttribute("tractor", tractor);
                                return "detalles";
                        }
                }
                return "redirect:/index";
        }

        // VER AÑADIR
        @GetMapping("/veraddtractor")
        public String verFormularioAdd(Model model) {
                Tractor tractor = new Tractor();
                tractor.setCode("JD00");
                model.addAttribute("tractor", tractor);
                return "add_tractor";
        }

        // AÑADIR
        @PostMapping("/addtractor")
        public String addTractor(@ModelAttribute Tractor tractor) {
                tractores.add(tractor); // Añadir el tractor a la lista
                return "redirect:/index"; // Redirigir a la página principal
        }

        // ELIMINAR TRACTOR
        @GetMapping("/eliminar/{id}")
        public String eliminarTractor(@PathVariable("id") String id) {
                if (!tractores.isEmpty()) {
                        tractores.removeIf(tractor -> tractor.getCode().equals(id));
                }

                return "redirect:/index"; // Redirigir a la página principal
        }
}