package ut4_pd0;

public enum operadores {
    SUMA('+'),
    RESTA('-'),
    MULTIPLICACION('*'),
    DIVISION('/');

    final char operando;

    operadores(char operando) {
        this.operando = operando;
    }

    public char getSimbolo() {
        return operando;
    }
}

