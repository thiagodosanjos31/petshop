package com.thiago.petshop.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Funcionario extends Pessoa {

    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "funcionario")
    List<Servico> servicos = new ArrayList<>();

    private String funcao;

    public Funcionario() {
    }

    public Funcionario(Integer id, String nome, String email, String codNacional, String funcao) {
        super(id, nome, email, codNacional);
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
}
