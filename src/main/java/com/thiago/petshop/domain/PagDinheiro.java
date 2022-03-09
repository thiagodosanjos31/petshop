package com.thiago.petshop.domain;

import com.thiago.petshop.domain.enuns.SituacaoPagamento;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PagDinheiro extends Pagamento {

    private static final long serialVersionUID = 1L;

    private Date dataVencimento;
    private Double desconto;

    public PagDinheiro() {
    }

    public PagDinheiro(Integer id, Double valor, SituacaoPagamento situacaoPagamento, Servico servico, Date dataVencimento,  Double desconto) {
        super(id, valor, situacaoPagamento, servico);
        this.dataVencimento = dataVencimento;
        this.desconto = desconto;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataPagamento) {
        this.dataVencimento = dataPagamento;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }
}
