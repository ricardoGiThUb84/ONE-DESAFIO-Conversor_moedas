package br.dominio;

public enum CONVERSOR_TEMPERATURA implements CONVERSOR {
    CELCIUS_FAHRENHEIT("Celcius para Fahrenheit", "C") {
        @Override
        public double formulaConversao(double valor) {
            return (valor * ((double) 9) / 5) + 32;
        }
    },

    FAHRENHEIT_CELCIUS("Fahrenheit para Celcius", "F") {
        @Override
        public double formulaConversao(double valor) {
            return (valor - 32) * (((double) 5) / 9);
        }
    };
    private String label;

    private String simbolo;

    CONVERSOR_TEMPERATURA(String label, String simbolo) {
        this.label = label;
        this.simbolo = simbolo;
    }

    public abstract double formulaConversao(double valor);

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getSimbol() {
        return simbolo;
    }

    @Override
    public double calcula(double valor) {
        return formulaConversao(valor);
    }
}
