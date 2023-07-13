package com.joelsonalves;

import javax.swing.JOptionPane;

public class App {
    public static void main( String[] args ) {
        
        final String CONVERSOR = "Conversor";
        final String CONVERSOR_MOEDA = "Conversor de Moedas";
        final String CONVERSOR_TEMPERATURA = "Conversor de Temperaturas";

        final String ESCOLHA_UMA_OPCAO = "Escolha uma opção:";
        final String DIGITE_UM_VALOR = "Digite um valor:";
        final String VALOR_INVALIDO = "O valor digitado é inválido.";
        final String FALHA_CONVERSOR_MOEDA = "Houve uma falha ao tentar realizar a conversão das moedas.";
        final String FALHA_CONVERSOR_TEMPERATURA = "Houve uma falha ao tentar realizar a conversão das temperaturas.";
        final String APP_FINALIZADO = "App Finalizado.";

        final String BRL_USD = "BRL-USD";
        final String BRL_EUR = "BRL-EUR";
        final String USD_BRL = "USD-BRL";
        final String USD_EUR = "USD-EUR";
        final String EUR_BRL = "EUR-BRL";
        final String EUR_USD = "EUR-USD";

        final String CELSIUS_FAHRENHEIT = "Celsius-Fahrenheit";
        final String CELSIUS_KELVIN = "Celsius-Kelvin";
        final String FAHRENHEIT_CELSIUS = "Fahrenheit-Celsius";
        final String FAHRENHEIT_KELVIN = "Fahrenheit-Kelvin";
        final String KELVIN_CELSIUS = "Kelvin-Celsius";
        final String KELVIN_FAHRENHEIT = "Kelvin-Fahrenheit";

        Object[] optionsPrincipal = {
            CONVERSOR_MOEDA,
            CONVERSOR_TEMPERATURA,
        };

        Object[] optionsMoeda = {
            BRL_USD,
            BRL_EUR,
            USD_BRL,
            USD_EUR,
            EUR_BRL,
            EUR_USD,
        };

        Object[] optionsTemperatura = {
            CELSIUS_FAHRENHEIT,
            CELSIUS_KELVIN,
            FAHRENHEIT_CELSIUS,
            FAHRENHEIT_KELVIN,
            KELVIN_CELSIUS,
            KELVIN_FAHRENHEIT,
        };

        MENU_PRINCIPAL:
        while (true) {

            Object selectedOption = JOptionPane.showInputDialog(null, ESCOLHA_UMA_OPCAO, CONVERSOR, JOptionPane.QUESTION_MESSAGE, null, optionsPrincipal, optionsPrincipal[0]);

            if (selectedOption == null) {

                JOptionPane.showMessageDialog(null, APP_FINALIZADO, CONVERSOR, JOptionPane.INFORMATION_MESSAGE);

                break MENU_PRINCIPAL;

            }

            if (selectedOption.toString() == CONVERSOR_MOEDA) {

                selectedOption = JOptionPane.showInputDialog(null, ESCOLHA_UMA_OPCAO, CONVERSOR_MOEDA, JOptionPane.QUESTION_MESSAGE, null, optionsMoeda, optionsMoeda[0]);

                if (selectedOption == null) {

                    continue MENU_PRINCIPAL;

                }

                String[] moeda = selectedOption.toString().split("-");

                Object valor = JOptionPane.showInputDialog(null, DIGITE_UM_VALOR, CONVERSOR_MOEDA, JOptionPane.QUESTION_MESSAGE);

                Double valorMoedaA;
                try {

                    valorMoedaA = Double.parseDouble(valor.toString().replace(",", "."));

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, VALOR_INVALIDO, CONVERSOR_MOEDA, JOptionPane.ERROR_MESSAGE);

                    continue MENU_PRINCIPAL;

                }
                
                Double valorMoedaB = ConversorMoeda.converter(moeda[0], valorMoedaA, moeda[1]);
                
                if (valorMoedaB != null) {

                    JOptionPane.showMessageDialog(null, String.format("%.2f%s%s%s%.2f%s%s%s", valorMoedaA, " (", moeda[0], ") equivale a ", valorMoedaB, " (", moeda[1], ")."), CONVERSOR_MOEDA, JOptionPane.INFORMATION_MESSAGE);

                } else {

                    JOptionPane.showMessageDialog(null, FALHA_CONVERSOR_MOEDA, CONVERSOR_MOEDA, JOptionPane.ERROR_MESSAGE);

                }

            } else if (selectedOption.toString() == CONVERSOR_TEMPERATURA) {

                selectedOption = JOptionPane.showInputDialog(null, ESCOLHA_UMA_OPCAO, CONVERSOR_TEMPERATURA, JOptionPane.QUESTION_MESSAGE, null, optionsTemperatura, optionsTemperatura[0]);

                if (selectedOption == null) {

                    continue MENU_PRINCIPAL;

                }

                String[] escala = selectedOption.toString().split("-");

                Object valor = JOptionPane.showInputDialog(null, DIGITE_UM_VALOR, CONVERSOR_TEMPERATURA, JOptionPane.QUESTION_MESSAGE);

                Double valorNaEscalaA;
                try {

                    valorNaEscalaA = Double.parseDouble(valor.toString().replace(",", "."));

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, VALOR_INVALIDO, CONVERSOR_TEMPERATURA, JOptionPane.ERROR_MESSAGE);

                    continue MENU_PRINCIPAL;

                }

                Double valorNaEscalaB = ConversorTemperatura.converter(escala[0], valorNaEscalaA, escala[1]);
                
                if (valorNaEscalaB != null) {

                    JOptionPane.showMessageDialog(null, String.format("%.2f%s%s%s%.2f%s%s%s", valorNaEscalaA, " (", escala[0], ") equivale a ", valorNaEscalaB, " (", escala[1], ")."), CONVERSOR_TEMPERATURA, JOptionPane.INFORMATION_MESSAGE);

                } else {

                    JOptionPane.showMessageDialog(null, FALHA_CONVERSOR_TEMPERATURA, CONVERSOR_TEMPERATURA, JOptionPane.ERROR_MESSAGE);

                }

            } 

        }

    }
}