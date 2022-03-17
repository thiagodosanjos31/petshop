package com.thiago.petshop.dto;

import com.thiago.petshop.domain.Categoria;
import com.thiago.petshop.domain.Produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private List<Produto> produtos = new ArrayList<>();

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria categoria) {
        this.nome = categoria.getNome();
        this.produtos.addAll(categoria.getProdutos());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
