package Vendas.Rest.Cliente;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Vendas.Repository.ClienteRepository;
import Vendas.model.Cliente;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("*")
public class ClienteController {
	@Autowired
	private ClienteRepository repository;
	
	@PostMapping
	public ResponseEntity Salvar(@RequestBody clienteFormRequest request) {
		
		Cliente cliente = request.toModel();
		
		repository.save(cliente);
		
		return ResponseEntity.ok(clienteFormRequest.fromModel(cliente));
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Void> Atualizar(@PathVariable Long id,@RequestBody clienteFormRequest request) {
		Optional<Cliente> clienteExistente = repository.findById(id);
		
		if(clienteExistente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Cliente cliente = request.toModel();
		cliente.setId(id);
		cliente.setDataCadastro(request.getCadastro());
		
		repository.save(cliente);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<clienteFormRequest> getById(@PathVariable Long id){
		return repository.findById(id)
				.map(clienteFormRequest::fromModel)
				.map(clienteFR -> ResponseEntity.ok(clienteFR))
				.orElseGet(()->ResponseEntity.notFound().build());
				
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){
		return repository.findById(id)
				.map(cliente->{
					repository.delete(cliente);
					return ResponseEntity.noContent().build();
				})
				.orElseGet(()->ResponseEntity.notFound().build());
				
	}
	
	@GetMapping
	public List<clienteFormRequest> getLista(){
		return repository
				.findAll()
				.stream()
				.map(clienteFormRequest::fromModel)
				.collect(Collectors.toList());
	}

}
