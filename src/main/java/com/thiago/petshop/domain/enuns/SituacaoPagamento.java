package com.thiago.petshop.domain.enuns;

public enum SituacaoPagamento {
    QUITADO(1, "quitado"),
    CANCELADO(2, "cancelado"),
    PENDENTE(3, "pendente");

    private int code;
    private String descricao;

    SituacaoPagamento(int code, String descricao) {
        this.code = code;
        this.descricao = descricao;
    }

    public static SituacaoPagamento toEnum(Integer code){
        if(code == null)
            return null;

        for(SituacaoPagamento situacaoPagamento : SituacaoPagamento.values()){
            if(code.equals(situacaoPagamento.getCode())){
                return situacaoPagamento;
            }
        }

        throw new IllegalArgumentException();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
