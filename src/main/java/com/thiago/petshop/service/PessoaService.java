package com.thiago.petshop.service;

import com.thiago.petshop.domain.Categoria;
import com.thiago.petshop.domain.Pessoa;
import com.thiago.petshop.repositories.PessoaRepository;
import com.thiago.petshop.service.exceptions.DataIntegrityExcepetion;
import com.thiago.petshop.service.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PessoaService {

    @Autowired
    PessoaRepository repo;

    public Pessoa getPessoaById(Integer id){
        Optional<Pessoa> pessoa = repo.findById(id);
        return pessoa.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto nao encontrado. ID: " + id + ", Tipo: " + Pessoa.class.getName()));
    }

    public Pessoa insert(Pessoa obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Pessoa update(Pessoa obj){
        getPessoaById(obj.getId());
        return repo.save(obj);
    }

    public void delete(Integer id){
        getPessoaById(id);
        try{
            repo.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityExcepetion("Pessoa nao pode ser deletada.");
        }
    }

    public List<Pessoa> findAll() {
        return repo.findAll();
    }
}
