package com.thiago.petshop.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Especie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;

    @OneToMany(mappedBy = "especie")
    private List<Pet> pets = new ArrayList<>();

    public Especie() {

    }

    public Especie(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.pets = pets;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Especie especie = (Especie) o;
        return id.equals(especie.id) && Objects.equals(descricao, especie.descricao) && Objects.equals(pets, especie.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
