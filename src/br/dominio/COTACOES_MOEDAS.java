package br.dominio;

public enum COTACOES_MOEDAS {


    DOLAR_REAL(5.19),

    REAL_DOLAR(0.19);

    private double cotacaoMoeda;

    COTACOES_MOEDAS(double cotacaoMoeda) {
        this.cotacaoMoeda = cotacaoMoeda;
    }

    public double getCotacaoMoeda() {
        return cotacaoMoeda;
    }
}
