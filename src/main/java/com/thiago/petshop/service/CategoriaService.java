package com.thiago.petshop.service;

import com.thiago.petshop.domain.Categoria;
import com.thiago.petshop.repositories.CategoriaRepository;
import com.thiago.petshop.service.exceptions.DataIntegrityExcepetion;
import com.thiago.petshop.service.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria findCategoriaById(Integer id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto nao encontrado. ID: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert(Categoria obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Categoria update(Categoria obj){
        findCategoriaById(obj.getId());
        return repo.save(obj);
    }

    public void delete(Integer id){
        findCategoriaById(id);
        try{
            repo.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityExcepetion("Categoria possui produtos. Nao e possivel deletar.");
        }
    }
}
