package br.dominio;

public enum CONVERSORES {

    CONVERSOR_DE_MOEDAS("Conversor de Moedas"),
    CONVERSOR_UNIDADE_MEDIDA("Conversor de Medidas"),
    CONVERSOR_TEMPERATURA("Conversor de Temperatura");

    private String label;

    CONVERSORES(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }


}
