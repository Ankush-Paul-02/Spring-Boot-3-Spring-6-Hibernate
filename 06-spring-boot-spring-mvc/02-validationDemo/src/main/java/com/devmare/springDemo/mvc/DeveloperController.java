package com.devmare.springDemo.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeveloperController {

    //! Add an init binder ... to convert trim input strings
    //! Remove leading and trailing whitespaces
    //! Resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("developer", new Developer());
        return "developer-form";
    }

    @PostMapping("/processForm")
    public String processFrom(
            @Valid @ModelAttribute("developer") Developer developer,
            BindingResult bindingResult) {
        System.out.println("Last name: | " + developer.getLastName() + " |");
        System.out.println("Binding result: " + bindingResult.toString());
        if (bindingResult.hasErrors()) {
            return "developer-form";
        } else {
            return "developer-confirmation";
        }
    }
}
