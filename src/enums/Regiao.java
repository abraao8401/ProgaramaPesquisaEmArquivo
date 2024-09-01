package enums;

public enum Regiao {
    NORTE(1),
    NORDESTE(2),
    SUDESTE(3),
    SUL(4),
    CENTRO_OESTE(5);

    private final int codigo;

    Regiao(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static Regiao fromCodigo(int codigo) {
        for (Regiao regiao : values()) {
            if (regiao.getCodigo() == codigo) {
                return regiao;
            }
        }
        return null;
    }
}
