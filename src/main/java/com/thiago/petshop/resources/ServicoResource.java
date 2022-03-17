package com.thiago.petshop.resources;

import com.thiago.petshop.domain.Pessoa;
import com.thiago.petshop.domain.Servico;
import com.thiago.petshop.dto.ServicoDTO;
import com.thiago.petshop.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/servicos")
public class ServicoResource {

    @Autowired
    ServicoService servicoService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Servico> getServico(@PathVariable Integer id){
        Servico servico = servicoService.findServicoById(id);
        return ResponseEntity.ok().body(servico);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> insert(@RequestBody Servico obj){
        obj = servicoService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Servico obj, @PathVariable Integer id){
        obj.setId(id);
        servicoService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        servicoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ServicoDTO>> findAll(){
        List<Servico> servicos = servicoService.findAll();
        List<ServicoDTO> servicosDto = servicos.stream().map(ServicoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(servicosDto);
    }
}
