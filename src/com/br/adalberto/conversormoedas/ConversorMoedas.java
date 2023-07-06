package com.br.adalberto.conversormoedas;

import java.text.DecimalFormat;

 class ConversorMoedas {
    public static double converterMoeda(double amount, String fromCurrency, String toCurrency) {
        if (fromCurrency.equals("Dólar") && toCurrency.equals("Real")) {
            return amount * 4.35;
        } else if (fromCurrency.equals("Euro") && toCurrency.equals("Real")) {
            return amount * 5.27;
        } else if (fromCurrency.equals("Libra") && toCurrency.equals("Real")) {
            return amount * 6.18;
        } else {
            return 0;
        }
    }

    public String formatCurrency(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(value);
    }
}
