
package com.example.calculadora.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class CalculadoraGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraView view = new CalculadoraView();
            view.setVisible(true);

            view.calcularButton.addActionListener((ActionEvent e) -> {
                try {
                    double a = Double.parseDouble(view.numero1Field.getText());
                    double b = Double.parseDouble(view.numero2Field.getText());
                    String operacion = (String) view.operacionBox.getSelectedItem();

                    String urlString = "http://localhost:8080/calculadora/operar?a=" + URLEncoder.encode(String.valueOf(a), "UTF-8")
                            + "&b=" + URLEncoder.encode(String.valueOf(b), "UTF-8")
                            + "&operacion=" + URLEncoder.encode(operacion, "UTF-8");

                    URL url = new URL(urlString);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");

                    int status = con.getResponseCode();
                    if (status == 200) {
                        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                        String inputLine;
                        StringBuilder content = new StringBuilder();
                        while ((inputLine = in.readLine()) != null) {
                            content.append(inputLine);
                        }
                        in.close();
                        view.resultadoLabel.setText("Resultado: " + content.toString());
                    } else {
                        view.resultadoLabel.setText("Error al llamar al servicio");
                    }
                    con.disconnect();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(view, "Por favor, ingresa números válidos");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view, "Error: " + ex.getMessage());
                }
            });
        });
    }
}
