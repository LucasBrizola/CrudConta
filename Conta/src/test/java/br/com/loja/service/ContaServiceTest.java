package br.com.loja.service;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.loja.dto.ContaDTO;

@RunWith(value=SpringRunner.class)
@SpringBootTest
public class ContaServiceTest {

	@Autowired
	private ContaService contaService;
	
	
	/*@Test
	public void deveSalvarUmaConta() {
		ContaDTO contaParaSalvar = new ContaDTO();
		
		contaParaSalvar.setNumero("351121");
		contaParaSalvar.setAgencia("0100");
		contaParaSalvar.setCpf("02721739085");
		contaParaSalvar.setDataCriacao(LocalDate.now());
		contaService.save(contaParaSalvar);
		ContaDTO contaSalva = contaService.findById(1);
		
		Assert.assertEquals(1, (int) contaSalva.getId());
		Assert.assertEquals("351121", contaSalva.getNumero());
		Assert.assertEquals("0100", contaSalva.getAgencia());
		Assert.assertEquals("02721739085", contaSalva.getCpf());
		Assert.assertNotNull(contaSalva.getDataCriacao());
		Assert.assertNull(contaSalva.getDataAtualizacao());
	}*/
	
	@Test
	public void deveSalvarDuasContas() {
		LocalDate dataCriacao = LocalDate.of(2018, 6, 10);
		LocalDate dataAtualizacao = LocalDate.of(2019, 8, 11);
		
		ContaDTO contaParaSalvar = new ContaDTO();
		
		contaParaSalvar.setNumero("351121");
		contaParaSalvar.setAgencia("0100");
		contaParaSalvar.setCpf("02721739085");
		contaParaSalvar.setDataCriacao(LocalDate.now());
		contaService.save(contaParaSalvar);
		
		contaParaSalvar.setNumero("231456");
		contaParaSalvar.setAgencia("0135");
		contaParaSalvar.setCpf("03054587010");
		contaParaSalvar.setDataCriacao(dataCriacao);
		contaParaSalvar.setDataAtualizacao(dataAtualizacao);
		contaService.save(contaParaSalvar);
		
		
		ContaDTO contaSalva = contaService.findById(2);
		
		Assert.assertEquals(2, (int) contaSalva.getId());
		Assert.assertEquals("231456", contaSalva.getNumero());
		Assert.assertEquals("0135", contaSalva.getAgencia());
		Assert.assertEquals("03054587010", contaSalva.getCpf());
		Assert.assertEquals(dataCriacao,contaSalva.getDataCriacao());
		Assert.assertEquals(dataAtualizacao,contaSalva.getDataAtualizacao());
	}
	
	@Test(expected=ServiceException.class)
	public void deveValidarSeACidadeJaExiste() {
		Cidade poa = new Cidade("Porto Alegre", rio);
		cidadeService.save(poa);
		cidadeService.save(poa);

	}
	
}
