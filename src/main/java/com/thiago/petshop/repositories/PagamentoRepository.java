package com.thiago.petshop.repositories;

import com.thiago.petshop.domain.Pagamento;
import com.thiago.petshop.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
