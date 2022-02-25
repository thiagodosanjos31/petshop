package com.thiago.petshop.resources;

import com.thiago.petshop.domain.Pessoa;
import com.thiago.petshop.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/pessoas/")
public class PessoaResource {

    @Autowired
    PessoaService pessoaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPessoa(@PathVariable Integer id){
        Pessoa pessoa = pessoaService.getPessoaById(id);
        return ResponseEntity.ok().body(pessoa);
    }
}
