package com.thiago.petshop.resources;

import com.thiago.petshop.domain.Servico;
import com.thiago.petshop.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicos/")
public class ServicoResource {

    @Autowired
    ServicoService servicoService;

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Servico> getServico(@PathVariable Integer id){
        Servico servico = servicoService.findServicoById(id);
        return ResponseEntity.ok().body(servico);
    }
}
