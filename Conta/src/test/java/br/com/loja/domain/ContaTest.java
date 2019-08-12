package br.com.loja.domain;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class ContaTest {
	
	@Test
	public void deveCriarUmaContaValida() {
		LocalDate dataCriacao = LocalDate.of(2018, 6, 10);
		LocalDate dataAtualizacao = LocalDate.of(2019, 8, 11);
		Conta conta = new Conta("351121", "0100", "02721739085", dataCriacao, dataAtualizacao);
				
		Assert.assertEquals("351121", conta.getNumero());
		Assert.assertEquals("0100", conta.getAgencia());
		Assert.assertEquals("02721739085", conta.getCpf());
		Assert.assertTrue(conta.isStatus());
		;
		Assert.assertEquals(dataCriacao, conta.getDataCriacao());
		Assert.assertEquals(dataAtualizacao, conta.getDataAtualizacao());
	}

}
