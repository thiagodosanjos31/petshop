package com.thiago.petshop.service;

import com.thiago.petshop.domain.Pessoa;
import com.thiago.petshop.repositories.PessoaRepository;
import com.thiago.petshop.service.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public Pessoa getPessoaById(Integer id){
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto nao encontrado. ID: " + id + ", Tipo: " + Pessoa.class.getName()));
    }
}
