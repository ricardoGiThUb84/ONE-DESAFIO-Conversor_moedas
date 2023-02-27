package br.entrada;

import br.dominio.CONVERSORES;
import br.dominio.CONVERSOR_MOEDAS;
import br.exceptions.ConversorNaoInformadoException;
import br.exceptions.ValorInvalidoException;

import java.util.Map;

public interface Prompt {

    String escolherConversor(CONVERSORES[] conversores,String titulo, String mensagem);

    String escolherOpcaoConversao(Map<String, String> conversores, String titulo, String mensagem) throws ConversorNaoInformadoException;


    double entradaValor() throws ValorInvalidoException;
}
