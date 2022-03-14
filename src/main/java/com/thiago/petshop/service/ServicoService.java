package com.thiago.petshop.service;

import com.thiago.petshop.domain.Categoria;
import com.thiago.petshop.domain.Servico;
import com.thiago.petshop.repositories.CategoriaRepository;
import com.thiago.petshop.repositories.ServicoRepository;
import com.thiago.petshop.service.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repo;

    public Servico findServicoById(Integer id){
        Optional<Servico> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto nao encontrado. ID: " + id + ", Tipo: " + Servico.class.getName()));
    }
}
