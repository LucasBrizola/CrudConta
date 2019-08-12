package br.com.loja.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

@Entity
@Table(name = "conta")
public class Conta extends BaseDominio {

	//Como String o id não funciona no hsqldb
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@NotEmpty
	@Size(max = 6, message = "numero não pode ter mais de 6 caracteres")
	private String numero;

	@NotNull
	@NotEmpty
	@Size(max = 4, message = "agencia não pode ter mais de 4 caracteres")
	private String agencia;

	@NotNull
	@NotEmpty
	@Size(max = 11, message = "cpf não pode ter mais de 11 caracteres")
	private String cpf;

	@NotNull
	private boolean status;

	@NotNull
	private LocalDate dataCriacao;

	private LocalDate dataAtualizacao;

	@SuppressWarnings("unused")
	private Conta() {
		// constructor for hibernate
	}

	public Conta(String numero, String agencia, String cpf, LocalDate dataCriacao, LocalDate dataAtualizacao) {
		this.numero = numero;
		this.agencia = agencia;
		this.cpf = cpf;
		this.status = true;
		this.dataCriacao = dataCriacao;
		this.dataAtualizacao = dataAtualizacao;
	}

	public Conta(Integer id, String numero, String agencia, String cpf, LocalDate dataCriacao,
			LocalDate dataAtualizacao) {
		this.id = id;
		this.numero = numero;
		this.agencia = agencia;
		this.cpf = cpf;
		this.status = true;
		this.dataCriacao = dataCriacao;
		this.dataAtualizacao = dataAtualizacao;
	}

	public Conta(Integer id, String numero, String agencia, String cpf, LocalDate dataCriacao) {
		this.id = id;
		this.numero = numero;
		this.agencia = agencia;
		this.cpf = cpf;
		this.status = true;
		this.dataCriacao = dataCriacao;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isStatus() {
		return status;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

}