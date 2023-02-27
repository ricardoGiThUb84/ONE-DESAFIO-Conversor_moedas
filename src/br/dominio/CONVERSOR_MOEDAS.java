package br.dominio;

public enum CONVERSOR_MOEDAS implements CONVERSOR {

    REAL_DOLAR("Real para Dólar", "R$", COTACOES_MOEDAS.REAL_DOLAR.getCotacaoMoeda()),
    DOLAR_REAL("Dólar para Real", "$", COTACOES_MOEDAS.DOLAR_REAL.getCotacaoMoeda());


    private String label;

    private String simbolo;
    private double fatorConversao;

    CONVERSOR_MOEDAS(String label, String simbolo, double fatorConversao) {
        this.label = label;
        this.simbolo = simbolo;
        this.fatorConversao = fatorConversao;
    }


    public String getLabel() {
        return label;
    }

    public String getSimbol() {
        return simbolo;
    }

    @Override
    public double calcula(double valor) {
        return valor * this.fatorConversao;
    }
}