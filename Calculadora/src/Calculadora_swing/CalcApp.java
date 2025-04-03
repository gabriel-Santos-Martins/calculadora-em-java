package Calculadora_swing;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CalcApp {

    JFrame frmCalculadora;
    private JTextField display;
    private Double num1, num2, resultado;
    private String operacao;
    private boolean novaOperacao;
    
    public CalcApp() {
        initialize();
    }

    private void initialize() {
        frmCalculadora = new JFrame();
        frmCalculadora.setTitle("Calculadora");
        frmCalculadora.setBounds(100, 100, 280, 400);
        frmCalculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCalculadora.getContentPane().setLayout(null);
        
        // Inicializa o display
        display = new JTextField();
        display.setText("0");
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont(new Font("Tahoma", Font.PLAIN, 40));
        display.setBounds(0, 9, 254, 91);
        display.setEditable(false);
        frmCalculadora.getContentPane().add(display);
        display.setColumns(10);
        
        // Botão AC (limpar tudo)
        JButton btn_apagar = new JButton("AC");
        btn_apagar.setBounds(9, 109, 52, 47);
        btn_apagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.setText("0");
                num1 = null;
                num2 = null;
                resultado = null;
                operacao = null;
                novaOperacao = false;
            }
        });
        frmCalculadora.getContentPane().add(btn_apagar);
        
        // Botões numéricos
        JButton btn_0 = new JButton("0");
        btn_0.setBounds(5, 300, 114, 47);
        btn_0.addActionListener(new NumeroActionListener("0"));
        frmCalculadora.getContentPane().add(btn_0);
        
        JButton btn_1 = new JButton("1");
        btn_1.setBounds(9, 165, 52, 36);
        btn_1.addActionListener(new NumeroActionListener("1"));
        frmCalculadora.getContentPane().add(btn_1);
        
        JButton btn_2 = new JButton("2");
        btn_2.setBounds(70, 165, 52, 36);
        btn_2.addActionListener(new NumeroActionListener("2"));
        frmCalculadora.getContentPane().add(btn_2);
        
        JButton btn_3 = new JButton("3");
        btn_3.setBounds(131, 165, 52, 36);
        btn_3.addActionListener(new NumeroActionListener("3"));
        frmCalculadora.getContentPane().add(btn_3);
        
        JButton btn_4 = new JButton("4");
        btn_4.setBounds(9, 210, 52, 36);
        btn_4.addActionListener(new NumeroActionListener("4"));
        frmCalculadora.getContentPane().add(btn_4);
        
        JButton btn_5 = new JButton("5");
        btn_5.setBounds(70, 210, 52, 36);
        btn_5.addActionListener(new NumeroActionListener("5"));
        frmCalculadora.getContentPane().add(btn_5);
        
        JButton btn_6 = new JButton("6");
        btn_6.setBounds(131, 210, 52, 36);
        btn_6.addActionListener(new NumeroActionListener("6"));
        frmCalculadora.getContentPane().add(btn_6);
        
        JButton btn_7 = new JButton("7");
        btn_7.setBounds(9, 255, 52, 36);
        btn_7.addActionListener(new NumeroActionListener("7"));
        frmCalculadora.getContentPane().add(btn_7);
        
        JButton btn_8 = new JButton("8");
        btn_8.setBounds(70, 255, 52, 36);
        btn_8.addActionListener(new NumeroActionListener("8"));
        frmCalculadora.getContentPane().add(btn_8);
        
        JButton btn_9 = new JButton("9");
        btn_9.setBounds(131, 255, 52, 36);
        btn_9.addActionListener(new NumeroActionListener("9"));
        frmCalculadora.getContentPane().add(btn_9);
        
        // Botão vírgula (decimal)
        JButton btn_virgula = new JButton(",");
        btn_virgula.setBounds(124, 300, 70, 47);
        btn_virgula.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!display.getText().contains(".")) {
                    display.setText(display.getText() + ".");
                }
            }
        });
        frmCalculadora.getContentPane().add(btn_virgula);
        
        // Botões de operação
        JButton btn_adicao = new JButton("+");
        btn_adicao.setBounds(192, 210, 60, 36);
        btn_adicao.addActionListener(new OperacaoActionListener("+"));
        frmCalculadora.getContentPane().add(btn_adicao);
        
        JButton btn_subtracao = new JButton("-");
        btn_subtracao.setBounds(192, 165, 60, 36);
        btn_subtracao.addActionListener(new OperacaoActionListener("-"));
        frmCalculadora.getContentPane().add(btn_subtracao);
        
        JButton btn_multiplicacao = new JButton("x");
        btn_multiplicacao.setBounds(131, 109, 52, 47);
        btn_multiplicacao.addActionListener(new OperacaoActionListener("*"));
        frmCalculadora.getContentPane().add(btn_multiplicacao);
        
        JButton btn_divisao = new JButton("/");
        btn_divisao.setBounds(192, 109, 60, 47);
        btn_divisao.addActionListener(new OperacaoActionListener("/"));
        frmCalculadora.getContentPane().add(btn_divisao);
        
        JButton btn_porcentagem = new JButton("%");
        btn_porcentagem.setBounds(70, 109, 52, 47);
        btn_porcentagem.addActionListener(new OperacaoActionListener("%"));
        frmCalculadora.getContentPane().add(btn_porcentagem);
        
        // Botão de resultado
        JButton btn_resultado = new JButton("=");
        btn_resultado.setBounds(199, 255, 60, 97);
        btn_resultado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (operacao != null) {
                    num2 = Double.parseDouble(display.getText().replace(",", "."));
                    
                    switch (operacao) {
                        case "+":
                            resultado = num1 + num2;
                            break;
                        case "-":
                            resultado = num1 - num2;
                            break;
                        case "*":
                            resultado = num1 * num2;
                            break;
                        case "/":
                            if (num2 != 0) {
                                resultado = num1 / num2;
                            } else {
                                display.setText("Erro");
                                return;
                            }
                            break;
                        case "%":
                            resultado = num1 * num2 / 100;
                            break;
                    }
                    
                    display.setText(String.valueOf(resultado).replace(".", ","));
                    num1 = resultado;
                    novaOperacao = true;
                }
            }
        });
        frmCalculadora.getContentPane().add(btn_resultado);
    }
    
    // Classe interna para tratar os eventos dos botões numéricos
    private class NumeroActionListener implements ActionListener {
        private String numero;
        
        public NumeroActionListener(String numero) {
            this.numero = numero;
        }
        
        public void actionPerformed(ActionEvent e) {
            if (display.getText().equals("0") || novaOperacao) {
                display.setText(numero);
                novaOperacao = false;
            } else {
                display.setText(display.getText() + numero);
            }
        }
    }
    
    // Classe interna para tratar os eventos dos botões de operação
    private class OperacaoActionListener implements ActionListener {
        private String operacao;
        
        public OperacaoActionListener(String operacao) {
            this.operacao = operacao;
        }
        
        public void actionPerformed(ActionEvent e) {
            if (num1 == null) {
                num1 = Double.parseDouble(display.getText().replace(",", "."));
            } else if (!novaOperacao) {
                num2 = Double.parseDouble(display.getText().replace(",", "."));
                switch (this.operacao) {
                    case "+":
                        num1 = num1 + num2;
                        break;
                    case "-":
                        num1 = num1 - num2;
                        break;
                    case "*":
                        num1 = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            num1 = num1 / num2;
                        } else {
                            display.setText("Erro");
                            return;
                        }
                        break;
                    case "%":
                        num1 = num1 * num2 / 100;
                        break;
                }
                display.setText(String.valueOf(num1).replace(".", ","));
            }
            novaOperacao = true;
            CalcApp.this.operacao = operacao;
        }
    }
}