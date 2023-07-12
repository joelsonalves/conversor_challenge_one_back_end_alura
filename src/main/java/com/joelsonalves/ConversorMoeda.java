package com.joelsonalves;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ConversorMoeda {


    public static Double obterTaxaDeCambio(String MoedaA, String MoedaB) {

        Double taxa = null;

        // Busca a taxa no Google Finance

        String URL = String.format("%s%s%s%s","https://www.google.com/finance/quote/", MoedaA, "-", MoedaB);

        try {

            // Obtem o conteúdo do document do HTML.
            Document document = Jsoup.connect(URL).get();

            // Extrai a DIV que contém a taxa
            Element element = document.select(String.format("%s%s%s%s%s", "div[data-source=\"", MoedaA, "\"][data-target=\"", MoedaB, "\"]")).first();
            
            // Extrai a taxa
            taxa = Double.parseDouble(element.text().split(" ")[0]);

        } catch (IOException e) {

            System.out.println(String.format("%s%s%s%s%s", "Houve uma falha ao tentar obter a taxa de conversão de ", MoedaA, " para ", MoedaB, "."));

        }

        return taxa;

    }
    
    public static Double converter(String MoedaA, double valorMoedaA, String MoedaB) {

        Double valorMoedaB = null;

        try {

            valorMoedaB = valorMoedaA * obterTaxaDeCambio(MoedaA, MoedaB);

        } catch (Exception e) {

            System.out.println(String.format("%s%.2f%s%s%s%s%s", "Não foi possível converter o valor ", valorMoedaA, " de ", MoedaA, " para ", MoedaB, "."));

        }

        return valorMoedaB;

    }

}
