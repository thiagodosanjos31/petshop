package com.thiago.petshop.domain;

import com.thiago.petshop.domain.enuns.SituacaoPagamento;

import javax.persistence.Entity;

@Entity
public class PagCartao extends Pagamento {

    private static final long serialVersionUID = 1L;

    private Integer parcelas;

    public PagCartao() {
    }

    public PagCartao(Integer id, Double valor, SituacaoPagamento situacaoPagamento, Servico servico, Integer parcelas) {
        super(id, valor, situacaoPagamento, servico);
        this.parcelas = parcelas;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }
}
