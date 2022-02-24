package com.thiago.petshop.domain;

import com.thiago.petshop.domain.enuns.SituacaoPagamento;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PagDinheiro extends Pagamento {

    private static final long serialVersionUID = 1L;

    private Date dataPagamento;
    private Double desconto;

    public PagDinheiro() {
    }

    public PagDinheiro(Integer id, Double valor, SituacaoPagamento situacaoPagamento, Date dataPagamento, Servico servico, Double desconto) {
        super(id, valor, situacaoPagamento, servico);
        this.dataPagamento = dataPagamento;
        this.desconto = desconto;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }
}
