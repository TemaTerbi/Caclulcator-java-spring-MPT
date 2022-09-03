package com.xuy.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("name", "mainPage");
        return "home";
    }

    @GetMapping("/calc")
    public String Calc(Model model) {
        model.addAttribute("title", 167);
        return "home";
    }

    @GetMapping("/result")
    public String Result(@RequestParam(value = "firstNumber", defaultValue = "10") int a, @RequestParam(value = "secondNumber", defaultValue = "20") int b, Model model) {
        int c = a + b;
        model.addAttribute("answer", c);
        return "result";
    }

    @PostMapping("/res")
    public String PostResult(@RequestParam(value = "firstNumber", defaultValue = "10") int a, @RequestParam(value = "secondNumber", defaultValue = "20") int b, @RequestParam(value = "operations", defaultValue = "+") String operation,  Model model) {
        int c = switch (operation) {
            case ("+") -> a + b;
            case ("-") -> a - b;
            case ("*") -> a * b;
            case ("/") -> a / b;
            default -> 0;
        };
        model.addAttribute("answer", c);
        return "result";
    }
}
