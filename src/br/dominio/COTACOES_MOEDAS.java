package br.dominio;

public enum COTACOES_MOEDAS {


    REAL_DOLAR(0.19),
    REAL_EURO(0.18),
    REAL_LIBRAS_ESTERLINAS(0.16),
    REAL_PESO_ARGENTINO(37.56),
    REAL_PESO_CHILENO(156.12),

    DOLAR_REAL(5.19),
    EURO_REAL(5.50),
    LIBRAS_ESTERLINAS_REAL(6.23),
    PESO_ARGENTINO_REAL(0.027),

    PESO_CHILENO_REAL(0.0063);


    private double cotacaoMoeda;

    COTACOES_MOEDAS(double cotacaoMoeda) {
        this.cotacaoMoeda = cotacaoMoeda;
    }

    public double getCotacaoMoeda() {
        return cotacaoMoeda;
    }
}
