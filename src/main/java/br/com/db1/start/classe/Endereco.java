package br.com.db1.start.classe;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.db1.start.tipo.TipoEndereco;
import br.com.db1.start.tipo.TipoLogradouro;

@Entity(name = "endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
	private Cidade cidade;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
	private Pessoa pessoa;
	
	@Column(nullable = false, length = 12)
	@Enumerated(EnumType.STRING)
	private TipoLogradouro tipoLogradouro;
	
	@Column(name = "logradouro", length = 120)
	private String logradouro;
	
	@Column(name = "numero", length = 6)
	private String numero;
	
	@Column(name = "complemento", length = 15)
	private String complemento;
	
	@Column(name = "cep", length = 10)
	private String cep;
	
	@Column(length = 15)
	private TipoEndereco tipoEndereco;
		
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}
	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}
	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}	
}
