package com.jeangabriel.cursomc.domain.enums;

public enum EstadoPagamento {
    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private final int cod;
    private final String descricao;

    private EstadoPagamento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    //static pode rodar sem instanciar
    public static EstadoPagamento toEnum(Integer cod) {
        if (cod == null)
            return null;

        //values()
        for (EstadoPagamento x : EstadoPagamento.values()) {
            if (cod.equals(x.getCod()))
                return x;
        }
        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
