package br.entrada;

import br.dominio.*;
import br.exceptions.ConversorNaoInformadoException;
import br.exceptions.ValorInvalidoException;

import javax.swing.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Tela {
    Prompt prompt;

    public Tela(Prompt prompt) {
        this.prompt = prompt;
    }

    public String escolherConversor(CONVERSORES[] conversores, String titulo, String mensagem) {
        return prompt.escolherConversor(conversores, titulo, mensagem);
    }

    public String escolherConversao(String tipoConversor) throws ValorInvalidoException, ConversorNaoInformadoException {


        switch (tipoConversor) {

            case "Conversor de Moedas":

                final Map<String, String> conversores = new LinkedHashMap<>();

                Arrays.stream(CONVERSOR_MOEDAS.values()).collect(Collectors.toList()).forEach(
                        s -> conversores.put(s.toString(), s.getLabel())
                );

                final CONVERSOR_MOEDAS conversorMoedas = Enum
                        .valueOf(CONVERSOR_MOEDAS.class, prompt
                                .escolherOpcaoConversao(conversores, "Conversor Moedas",
                                        "Escolha uma moeda para realizar a conversão:"));

                return resultadoConversao(conversorMoedas, "2");

            case "Conversor de Medidas":

                final Map<String, String> conversoresMedidas = new LinkedHashMap<>();

                Arrays.stream(CONVERSOR_MEDIDAS.values()).collect(Collectors.toList()).forEach(
                        s -> conversoresMedidas.put(s.toString(), s.getLabel())
                );

                final CONVERSOR_MEDIDAS conversorM = Enum
                        .valueOf(CONVERSOR_MEDIDAS.class, prompt.escolherOpcaoConversao(conversoresMedidas,
                                "Conversor Medidas",
                                "Escolha uma medida para realizar a conversão:"));

                return resultadoConversao(conversorM, "2");

            case "Conversor de Temperatura":

                Map<String, String> conversorTemperatura = Arrays.stream(CONVERSOR_TEMPERATURA.values())
                        .collect(Collectors.toMap(CONVERSOR_TEMPERATURA::toString, CONVERSOR_TEMPERATURA::getLabel));


                final CONVERSOR_TEMPERATURA conversorT = Enum.valueOf(CONVERSOR_TEMPERATURA.class,
                        prompt.escolherOpcaoConversao(conversorTemperatura, "Conversor Temperaturas",
                                "Escolha uma temperatura para realizar a conversão:"));

                return resultadoConversao(conversorT, "2");

        }

        return null;

    }

    private String resultadoConversao(CONVERSOR tipoConversor, String precisaoCasaDecimal) throws ValorInvalidoException {
        return String.format("O valor da conversão é:%s %." + precisaoCasaDecimal + "f ",
                tipoConversor.getSimbol(),
                tipoConversor.calcula(prompt.entradaValor()));
    }


    public void mensagem(String message) {

        JOptionPane.showMessageDialog(null, message);
    }

    public int desejaContinuar(String s) {


        final int i = JOptionPane.showConfirmDialog(null, s);

        System.out.println("dentro do show confirm " + i);

        return i;
    }
}
