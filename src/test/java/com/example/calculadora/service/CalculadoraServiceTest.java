package com.example.calculadora.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraServiceTest {

    private final CalculadoraService calculadoraService = new CalculadoraService();

    @Test
    void testSuma() {
        double resultado = calculadoraService.operar(5, 3, "suma");
        assertEquals(8, resultado);
    }

    @Test
    void testResta() {
        double resultado = calculadoraService.operar(10, 4, "resta");
        assertEquals(6, resultado);
    }

    @Test
    void testMultiplicacion() {
        double resultado = calculadoraService.operar(2, 3, "multiplicacion");
        assertEquals(6, resultado);
    }

    @Test
    void testDivision() {
        double resultado = calculadoraService.operar(10, 2, "division");
        assertEquals(5, resultado);
    }

    @Test
    void testDivisionPorCero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadoraService.operar(10, 0, "division");
        });
        assertEquals("No se puede dividir por cero", exception.getMessage());
    }

    @Test
    void testOperacionInvalida() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadoraService.operar(5, 2, "potencia");
        });
        assertEquals("Operación no válida", exception.getMessage());
    }
}
