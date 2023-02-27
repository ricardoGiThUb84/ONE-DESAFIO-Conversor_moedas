package br.entrada;

import br.dominio.CONVERSORES;
import br.exceptions.ConversorNaoInformadoException;
import br.exceptions.ValorInvalidoException;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JOPrompt implements Prompt {

    @Override
    public String escolherConversor(CONVERSORES[] conversores, String titulo, String mensagem) {

        List<String> conversor = Arrays.stream(conversores)
                .collect(Collectors.toList()).stream().map(c -> c.getLabel()).collect(Collectors.toList());


        String conversorEscolhido = (String) JOptionPane.showInputDialog(null, mensagem,
                titulo, JOptionPane.QUESTION_MESSAGE, null, conversor.toArray(), conversor.get(0));


        return conversorEscolhido;

    }

    @Override
    public String escolherOpcaoConversao(Map<String, String> conversores, String titulo, String mensagem) throws ConversorNaoInformadoException {

        List<String> conversor = conversores.values().stream().toList();

        String conversorEscolhido = (String) JOptionPane
                .showInputDialog(null, mensagem,
                        titulo, JOptionPane.QUESTION_MESSAGE, null, conversor.toArray(), conversor.get(0));

        if (conversorEscolhido == null)
            throw new ConversorNaoInformadoException("É preciso escolher um conversor para efetuar o cálculo.");

        return conversores.entrySet().stream()
                .filter((a) -> a.getValue().equalsIgnoreCase(conversorEscolhido))
                .map(s -> s.getKey()).collect(Collectors.toList()).get(0);
    }

    @Override
    public double entradaValor() throws ValorInvalidoException {

        String valor = JOptionPane.showInputDialog("Digite um valor:");
        boolean isNumber = Pattern.compile("\\d+.?\\d{0,2}?").matcher(valor).matches();

        if (!isNumber) {
            throw new ValorInvalidoException("Digite um número válido.");
        }

        return Double.valueOf(valor);
    }
}
