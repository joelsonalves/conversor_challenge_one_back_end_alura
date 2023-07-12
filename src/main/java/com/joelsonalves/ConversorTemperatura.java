package com.joelsonalves;

public class ConversorTemperatura {

    public static final String CELSIUS = "Celsius";
    public static final String FAHRENHEIT = "Fahrenheit";
    public static final String KELVIN = "Kelvin";

    public static Double converter(String escalaA, double valorNaEscalaA, String escalaB) {

        Double valorNaEscalaB = null;

        switch (escalaA) {

            case CELSIUS:

                switch (escalaB) {

                    case FAHRENHEIT:

                        valorNaEscalaB = valorNaEscalaA * 9 / 5 + 32;

                        break;

                    
                    case KELVIN:

                        valorNaEscalaB = valorNaEscalaA + 273.15;

                        break;

                }
                
                break;
        
            case FAHRENHEIT:

                switch (escalaB) {

                    case CELSIUS:

                        valorNaEscalaB = (valorNaEscalaA - 32) * 5 / 9;

                        break;

                    
                    case KELVIN:

                        valorNaEscalaB = (valorNaEscalaA + 459.67) * 5 / 9;

                        break;

                }

                break;

            case KELVIN:

                switch (escalaB) {

                    case CELSIUS:

                        valorNaEscalaB = valorNaEscalaA - 273.15;

                        break;

                    
                    case FAHRENHEIT:

                        valorNaEscalaB = valorNaEscalaA * 9 / 5 - 459.67;

                        break;

                }

                break;

        }

        return valorNaEscalaB;

    }
    
}
