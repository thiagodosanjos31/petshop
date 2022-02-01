package com.thiago.petshop.resources;

import com.thiago.petshop.domain.Categoria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> mostrar(){
        Categoria cat1 = new Categoria(1, "Alimento");
        Categoria cat2 = new Categoria(2, "Cosmetico");
        Categoria cat3 = new Categoria(3, "Remedio");

        List<Categoria> categorias = new ArrayList<>();
        categorias.add(cat1);
        categorias.add(cat2);
        categorias.add(cat3);

        return categorias;
    }
}
