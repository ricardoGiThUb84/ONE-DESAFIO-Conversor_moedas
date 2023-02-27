package br.dominio;

public enum CONVERSOR_MOEDAS implements CONVERSOR {

    REAL_DOLAR("Reais a Dólar", "$", COTACOES_MOEDAS.REAL_DOLAR.getCotacaoMoeda()),
    REAL_EURO("Reais a Euro", "€", COTACOES_MOEDAS.REAL_EURO.getCotacaoMoeda()),
    REAL_LIBRAS_ESTERLINAS("Reais a Libras Esterlinas", "£", COTACOES_MOEDAS.REAL_LIBRAS_ESTERLINAS.getCotacaoMoeda()),
    REAL_PESO_ARGENTINO("Reais a Peso argentino", "$", COTACOES_MOEDAS.REAL_PESO_ARGENTINO.getCotacaoMoeda()),
    REAL_PESO_CHILENO("Reais a Peso Chileno", "$", COTACOES_MOEDAS.REAL_PESO_CHILENO.getCotacaoMoeda()),
    DOLAR_REAL("Dólar para Real", "R$", COTACOES_MOEDAS.DOLAR_REAL.getCotacaoMoeda()),
    EURO_REAL("Euro a Reais", "R$", COTACOES_MOEDAS.EURO_REAL.getCotacaoMoeda()),
    LIBRAS_ESTERLINAS_REAL("Libras Esterlinas a Reais", "R$", COTACOES_MOEDAS.LIBRAS_ESTERLINAS_REAL.getCotacaoMoeda()),
    PESO_ARGENTINO_REAL("Peso argentino a Reais", "R$", COTACOES_MOEDAS.PESO_ARGENTINO_REAL.getCotacaoMoeda()),
    PESO_CHILENO_REAL("Peso Chileno a Reais", "R$", COTACOES_MOEDAS.PESO_CHILENO_REAL.getCotacaoMoeda());

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