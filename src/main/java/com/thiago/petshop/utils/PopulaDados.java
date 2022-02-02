package com.thiago.petshop.utils;

import com.thiago.petshop.domain.Categoria;
import com.thiago.petshop.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class PopulaDados {

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostConstruct
    public void cadastrar(){
        Categoria cat1 = new Categoria(null, "Alimento");
        Categoria cat2 = new Categoria(null, "Remedio");
        Categoria cat3 = new Categoria(null, "Cosmetico");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    }

}
