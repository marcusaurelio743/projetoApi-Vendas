package Vendas.Rest.Produtos;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Vendas.Repository.ProdutoRepository;
import Vendas.model.Produto;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public List<ProdutoFormRequest> listaProdutos(){
		return  repository.findAll().
				stream().map( ProdutoFormRequest:: fromModel).collect(Collectors.toList());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ProdutoFormRequest> buscaPorId(@PathVariable Long id) {
		Optional<Produto> produtoExistente = repository.findById(id);
		if(produtoExistente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		ProdutoFormRequest produto = produtoExistente.map(ProdutoFormRequest::fromModel).get();
		return ResponseEntity.ok(produto);
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProdutoFormRequest salvar(@RequestBody ProdutoFormRequest produto) {
		
		Produto EntidadeProduto = produto.toModel();
		
		repository.save(EntidadeProduto);
		
		return ProdutoFormRequest.fromModel(EntidadeProduto);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Void> Atualizar(@PathVariable Long id, @RequestBody ProdutoFormRequest produto) {
		
		Optional<Produto> produtoExistente = repository.findById(id);
		
		if(produtoExistente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Produto entidade = produto.toModel();
		entidade.setId(id);
		entidade.setDatacadastro(produtoExistente.get().getDatacadastro());
		repository.save(entidade);
		return ResponseEntity.ok().build();
		
	}
	@DeleteMapping("{id}")
	public ResponseEntity<Void> Deletar(@PathVariable Long id){
		Optional<Produto> produtoExistente = repository.findById(id);
		
			if(produtoExistente.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
		
			repository.delete(produtoExistente.get());
		 
		 return ResponseEntity.noContent().build();
		
	}

}
