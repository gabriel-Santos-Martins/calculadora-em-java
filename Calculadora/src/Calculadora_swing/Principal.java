package Calculadora_swing;

import java.awt.EventQueue;

public class Principal {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CalcApp calculadora = new CalcApp();
                calculadora.frmCalculadora.setVisible(true); // Exibir a interface
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
