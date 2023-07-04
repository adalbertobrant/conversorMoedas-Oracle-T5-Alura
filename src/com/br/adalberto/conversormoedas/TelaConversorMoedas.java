package com.br.adalberto.conversormoedas;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TelaConversorMoedas extends JFrame {

    private String selectedOption;
    private String selectedCoin = "Real";
    private DefaultTableModel tableModel;
    private JTable conversionTable;
    private double amount;

    public TelaConversorMoedas(String selectedOption) {
        this.selectedOption = selectedOption;

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Criação do JComboBox
        String[] currencies = {"Dólar", "Euro", "Libra"};
        JComboBox<String> comboBox = new JComboBox<>(currencies);
        add(comboBox);

        // Criação do JTextField
        JTextField textField = new JTextField(10);
        add(textField);

        JButton convertButton = new JButton("Converter");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                try {
                    double amount = parseAmount(input);
                    double convertedAmount = converterMoeda(amount, comboBox.getSelectedItem().toString(), selectedCoin);
                    adicionarConversaoNaTabela(comboBox.getSelectedItem().toString(), convertedAmount);
                } catch (NumberFormatException ex) {
                    exibirMensagemErro("Valor inválido. Insira um número válido.");
                }
            }
        });
        add(convertButton);

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu();
            }
        });
        add(backButton);

        // Criação da tabela de conversões
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Moeda");
        tableModel.addColumn("Cotação");
        tableModel.addColumn("Valor da Conversão");
        tableModel.addColumn("Data");

        conversionTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(conversionTable);
        scrollPane.setPreferredSize(new java.awt.Dimension(780, 300));
        add(scrollPane);
    }

    private double parseAmount(String input) {
        // Substitui vírgula por ponto para permitir números no formato 2,4
        input = input.replace(",", ".");
        return Double.parseDouble(input);
    }

    private double converterMoeda(double amount, String fromCurrency, String toCurrency) {
        // Aqui você pode implementar a lógica de conversão de moedas
        // Utilize as informações das moedas selecionadas e a quantidade inserida pelo usuário
        // Retorne o valor convertido
    	this.amount = amount;

        // Exemplo de conversão fixa para demonstração
        if (fromCurrency.equals("Dólar") && toCurrency.equals("Real")) {
            return amount * 5.35; // Conversão de Dólar para Real
        } else if (fromCurrency.equals("Euro") && toCurrency.equals("Real")) {
            return amount * 6.27; // Conversão de Euro para Real
        } else if (fromCurrency.equals("Libra") && toCurrency.equals("Real")) {
            return amount * 7.18; // Conversão de Libra para Real
        } else {
            return 0; // Conversão não suportada ou inválida
        }
    }

  //  private void exibirResultado(double convertedAmount) {
   //     JLabel resultLabel = new JLabel("Conversão Realizada com Sucesso");
    //    add(resultLabel);
   //     revalidate();
    //    repaint();
   // }

    private void adicionarConversaoNaTabela(String moeda, double valorConversao) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        String data = dateFormat.format(new Date());
        moeda = moeda + " "+String.valueOf(amount);
        tableModel.addRow(new Object[]{moeda, selectedCoin, formatCurrency(valorConversao), data});
    }

    private String formatCurrency(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(value);
    }

    private void exibirMensagemErro(String mensagem) {
        JLabel errorLabel = new JLabel(mensagem);
        add(errorLabel);
        revalidate();
        repaint();
    }
}
