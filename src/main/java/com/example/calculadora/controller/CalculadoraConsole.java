package com.example.calculadora.controller;

import com.example.calculadora.service.CalculadoraService;
import java.util.Scanner;

public class CalculadoraConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculadoraService calculadoraService = new CalculadoraService();

        System.out.println("Ingrese el primer número:");
        double a = scanner.nextDouble();

        System.out.println("Ingrese el segundo número:");
        double b = scanner.nextDouble();

        System.out.println("Ingrese la operación (suma, resta, multiplicacion, division):");
        String operacion = scanner.next();

        try {
            double resultado = calculadoraService.operar(a, b, operacion);
            System.out.println("El resultado es: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}