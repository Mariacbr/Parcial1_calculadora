package com.example.calculadora.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculadoraControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSuma() throws Exception {
        mockMvc.perform(get("/calculadora/operar?a=5&b=3&operacion=suma"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.resultado").value(8)); // Verifica que la respuesta JSON tenga el resultado esperado
    }

    @Test
    void testDivisionPorCero() throws Exception {
        mockMvc.perform(get("/calculadora/operar?a=10&b=0&operacion=division"))
                .andExpect(status().isBadRequest()); // Esperamos un error 400 (Bad Request)
    }
}

