package com.example.calculadora.controller;

import com.example.calculadora.service.CalculadoraService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
    private final CalculadoraService calculadoraService;

    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @GetMapping("/operar")
    public double operar(@RequestParam double a, @RequestParam double b, @RequestParam String operacion) {
        return calculadoraService.operar(a, b, operacion);
    }
}