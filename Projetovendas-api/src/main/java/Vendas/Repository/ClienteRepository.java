package Vendas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Vendas.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
