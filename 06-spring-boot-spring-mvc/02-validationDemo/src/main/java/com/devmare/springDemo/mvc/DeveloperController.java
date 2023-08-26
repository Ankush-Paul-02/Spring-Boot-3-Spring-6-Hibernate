package com.devmare.springDemo.mvc;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeveloperController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("developer", new Developer());
        return "developer-form";
    }

    @PostMapping("/processForm")
    public String processFrom(
            @Valid @ModelAttribute("developer") Developer developer,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "developer-form";
        } else {
            return "developer-confirmation";
        }
    }
}
