package Vendas.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private LocalDate nascimento;
	private String cpf;
	private String endereco;
	private String telefone;
	
	@Column(name="data_cadastro")
	private LocalDate dataCadastro;
	
	private String email;
	
	
	

	public Cliente() {
		super();
		
	}
	

	public Cliente(String nome, LocalDate nascimento, String cpf, String endereco, String telefone, String email) {
		super();
		this.nome = nome;
		this.nascimento = nascimento;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}


	public Cliente(Long id, String nome, LocalDate nascimento, String cpf, String endereco, String telefone,
			LocalDate dataCadastro, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.dataCadastro = dataCadastro;
		this.email = email;
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

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", nascimento=" + nascimento + ", cpf=" + cpf + ", endereco="
				+ endereco + ", telefone=" + telefone + ", dataCadastro=" + dataCadastro + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
