package com.thiago.petshop.resources;

import com.thiago.petshop.domain.Pessoa;
import com.thiago.petshop.dto.PessoaDTO;
import com.thiago.petshop.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

    @Autowired
    PessoaService pessoaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPessoa(@PathVariable Integer id){
        Pessoa pessoa = pessoaService.getPessoaById(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> insert(@RequestBody Pessoa obj){
        obj = pessoaService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Pessoa obj, @PathVariable Integer id){
        obj.setId(id);
        pessoaService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PessoaDTO>> findAll(){
        List<Pessoa> pessoas = pessoaService.findAll();
        List<PessoaDTO> listDto = pessoas.stream().map(PessoaDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}
