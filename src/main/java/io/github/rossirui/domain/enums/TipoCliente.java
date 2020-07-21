package io.github.rossirui.domain.enums;

public enum TipoCliente {

    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private int cod;
    private String descricao;

    private TipoCliente(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return this.cod;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static TipoCliente toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(TipoCliente tp : TipoCliente.values()) {
            if(cod.equals(tp.getCod())) {
                return tp;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
