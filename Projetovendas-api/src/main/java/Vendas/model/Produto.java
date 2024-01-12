package Vendas.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100)
	private String nome;
	
	@Column(length = 255)
	private String descricao;
	
	@Column
	private String sku;
	
	@Column(precision = 16,scale = 2)
	private BigDecimal preco;
	
	@Column
	private LocalDate datacadastro;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public void setDatacadastro(LocalDate datacadastro) {
		this.datacadastro = datacadastro;
	}
	public LocalDate getDatacadastro() {
		return datacadastro;
	}
	
	@PrePersist
	public void prePrersist() {
		setDatacadastro(LocalDate.now());
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", sku=" + sku + ", preco=" + preco
				+ "]";
	}

	public Produto() {
		super();
		
	}
	public Produto(String nome, String descricao, BigDecimal preco, String sku) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.sku = sku;
	}
	public Produto(Long id, String nome, String descricao, BigDecimal preco, String sku) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.sku = sku;
	}
	
	
	public Produto(Long id, String nome, String descricao, BigDecimal preco, String sku, LocalDate dataCadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.sku = sku;
		this.datacadastro = dataCadastro;
	}
	
	
	
	
	

}
