package com.example.calculadora.controller;

import javax.swing.*;

public class CalculadoraView extends JFrame {

    public JTextField numero1Field;
    public JTextField numero2Field;
    public JComboBox<String> operacionBox;
    public JButton calcularButton;
    public JLabel resultadoLabel;

    public CalculadoraView() {
        setTitle("Calculadora REST - Spring Boot");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setBackground(new java.awt.Color(245, 245, 245));
        panel.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Calculadora REST");
        titleLabel.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 20));
        titleLabel.setForeground(new java.awt.Color(33, 33, 33));

        numero1Field = new JTextField(10);
        numero2Field = new JTextField(10);

        String[] operaciones = {"suma", "resta", "multiplicacion", "division"};
        operacionBox = new JComboBox<>(operaciones);

        calcularButton = new JButton("Calcular");
        calcularButton.setBackground(new java.awt.Color(33, 150, 243));
        calcularButton.setForeground(java.awt.Color.WHITE);

        resultadoLabel = new JLabel("Resultado: ");
        resultadoLabel.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 16));

        // Layout positions
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Número 1:"), gbc);

        gbc.gridx = 1;
        panel.add(numero1Field, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Número 2:"), gbc);

        gbc.gridx = 1;
        panel.add(numero2Field, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Operación:"), gbc);

        gbc.gridx = 1;
        panel.add(operacionBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(calcularButton, gbc);

        gbc.gridy++;
        panel.add(resultadoLabel, gbc);

        add(panel);
    }
}
