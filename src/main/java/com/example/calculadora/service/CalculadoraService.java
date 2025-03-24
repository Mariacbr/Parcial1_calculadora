package com.example.calculadora.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {
    public double operar(double a, double b, String operacion) {
        return switch (operacion.toLowerCase()) {
            case "suma" -> a + b;
            case "resta" -> a - b;
            case "multiplicacion" -> a * b;
            case "division" -> {
                if (b == 0) {
                    throw new IllegalArgumentException("No se puede dividir por cero");
                }
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Operación no válida");
        };
    }
}