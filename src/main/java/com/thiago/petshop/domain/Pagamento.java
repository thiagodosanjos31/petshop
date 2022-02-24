package com.thiago.petshop.domain;

import com.thiago.petshop.domain.enuns.SituacaoPagamento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private Double valor;
    private SituacaoPagamento situacaoPagamento;

    @OneToOne
    @JoinColumn(name = "id_servico")
    @MapsId
    private Servico servico;

    public Pagamento() {
    }

    public Pagamento(Integer id, Double valor, SituacaoPagamento situacaoPagamento, Servico servico) {
        this.id = id;
        this.valor = valor;
        this.situacaoPagamento = situacaoPagamento;
        this.servico = servico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public SituacaoPagamento getSituacaoPagamento() {
        return situacaoPagamento;
    }

    public void setSituacaoPagamento(SituacaoPagamento situacaoPagamento) {
        this.situacaoPagamento = situacaoPagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return id.equals(pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
