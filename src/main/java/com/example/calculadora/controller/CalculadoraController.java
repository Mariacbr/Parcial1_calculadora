package com.example.calculadora.controller;

import com.example.calculadora.service.CalculadoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
    private final CalculadoraService calculadoraService;

    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @GetMapping("/operar")
    public ResponseEntity<Map<String, Object>> operar(
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam String operacion) {
        try {
            double resultado = calculadoraService.operar(a, b, operacion);
            return ResponseEntity.ok(Map.of("resultado", resultado));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
