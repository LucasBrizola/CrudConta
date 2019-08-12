package br.com.loja.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public class ContaDTO {

	private Integer id;

	@NotNull
	@NotEmpty
	private String nome;

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
	@CPF
	private String cpf;

	@NotNull
	private boolean status;

	@NotNull
	private LocalDate dataCriacao;

	private LocalDate dataAtualizacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public void setStatus(boolean status) {
		this.status = status;
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
