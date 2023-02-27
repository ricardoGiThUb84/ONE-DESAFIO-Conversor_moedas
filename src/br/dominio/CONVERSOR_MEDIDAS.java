package br.dominio;

public enum CONVERSOR_MEDIDAS implements CONVERSOR{

    METRO_CENTIMETRO("Metro para Centímetro", "cm", 100),
    CENTIMETRO_METRO("Centímetro para Metro", "m",0.01);

    private String label;
    private double valorConversao;

    private String simbolo;

    CONVERSOR_MEDIDAS(String label,String simbolo, double valorConversao) {
        this.label = label;
        this.simbolo = simbolo;
        this.valorConversao = valorConversao;
    }

    @Override
    public String getSimbol() {
        return simbolo;
    }
    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public double calcula(double valor) {
        return valor * this.valorConversao;
    }
}
