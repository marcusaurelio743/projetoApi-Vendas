package Vendas.Rest.Cliente;

import java.time.LocalDate;

import Vendas.model.Cliente;

public class clienteFormRequest {
	private Long id;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private String endereco;
	private String telefone;
	private String email;
	
	
	public clienteFormRequest(Long id, String nome, String cpf, LocalDate dataNascimento, String endereco,
			String telefone, String email, LocalDate cadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.cadastro = cadastro;
	}
	public clienteFormRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getCadastro() {
		return cadastro;
	}
	public void setCadastro(LocalDate cadastro) {
		this.cadastro = cadastro;
	}
	private LocalDate cadastro;
	
	public Cliente toModel() {
		return new Cliente(id, nome, dataNascimento, cpf, endereco, telefone, cadastro, email);
	}
	
	public static clienteFormRequest fromModel(Cliente cliente) {
		return new clienteFormRequest(
				cliente.getId(), 
				cliente.getNome(),
				cliente.getCpf(),
				cliente.getNascimento(),
				cliente.getEndereco(),
				cliente.getTelefone(),
				cliente.getEmail(),
				cliente.getDataCadastro());
	}
	

}
