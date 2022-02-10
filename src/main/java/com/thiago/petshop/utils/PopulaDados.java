package com.thiago.petshop.utils;

import com.thiago.petshop.domain.*;
import com.thiago.petshop.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class PopulaDados {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    EspecieRepository especieRepository;

    @Autowired
    RacaRepository racaRepository;

    @Autowired
    PetRepository petRepository;

    @PostConstruct
    public void cadastrar(){
        Categoria cat1 = new Categoria(null, "Alimento");
        Categoria cat2 = new Categoria(null, "Remedio");
        Categoria cat3 = new Categoria(null, "Cosmetico");

        Produto p1 = new Produto(null, "Racao", 100.0);
        Produto p2 = new Produto(null, "Sache", 80.0);
        Produto p3 = new Produto(null, "Vermifugo", 50.0);
        Produto p4 = new Produto(null, "Shampoo", 20.0);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2));
        cat2.getProdutos().addAll(Arrays.asList(p3, p4));
        cat3.getProdutos().add(p4);

        p1.getCategorias().add(cat1);
        p2.getCategorias().add(cat1);
        p3.getCategorias().add(cat3);
        p4.getCategorias().addAll(Arrays.asList(cat2, cat3));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

        Especie esp1 = new Especie(null, "Cachorro");
        Especie esp2 = new Especie(null, "Gato");

        Raca raca1 = new Raca(null, "Shitzu");
        Raca raca2 = new Raca(null, "Akita");
        Raca raca3 = new Raca(null, "Persa");

        Pet pet1 = new Pet(null, "John", 6, esp1, raca1);
        Pet pet2 = new Pet(null, "Hana", 5, esp1, raca2);
        Pet pet3 = new Pet(null, "Mewth", 8, esp2, raca3);

        especieRepository.saveAll(Arrays.asList(esp1, esp2));
        racaRepository.saveAll(Arrays.asList(raca1, raca2, raca3));
        petRepository.saveAll(Arrays.asList(pet1, pet2, pet3));

    }

}
