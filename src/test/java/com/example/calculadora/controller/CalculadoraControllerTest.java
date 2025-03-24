package com.example.calculadora.controller;

import com.example.calculadora.service.CalculadoraService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CalculadoraControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSuma() throws Exception {
        mockMvc.perform(get("/calculadora/operar")
                        .param("a", "5")
                        .param("b", "3")
                        .param("operacion", "suma"))
                .andExpect(status().isOk())
                .andExpect(content().string("8.0"));
    }

    @Test
    void testResta() throws Exception {
        mockMvc.perform(get("/calculadora/operar")
                        .param("a", "10")
                        .param("b", "4")
                        .param("operacion", "resta"))
                .andExpect(status().isOk())
                .andExpect(content().string("6.0"));
    }


}

