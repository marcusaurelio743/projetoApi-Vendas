package Vendas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Vendas.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
