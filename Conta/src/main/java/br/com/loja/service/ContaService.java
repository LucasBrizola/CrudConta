package br.com.loja.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.domain.Conta;
import br.com.loja.dto.ContaDTO;
import br.com.loja.repository.ContaRepository;

@Service
public class ContaService {

	private ContaRepository contaRepository;

	@Autowired
	public ContaService(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}

	public void save(ContaDTO contaDTO) {
		String numero = contaDTO.getNumero();
		String agencia = contaDTO.getAgencia();
		String cpf = contaDTO.getCpf();
		LocalDate dataCriacao = contaDTO.getDataCriacao();
		LocalDate dataAtualizacao = contaDTO.getDataAtualizacao();

		Conta conta = new Conta(numero, agencia, cpf, dataCriacao, dataAtualizacao);
		this.contaRepository.saveAndFlush(conta);
	}

	public Conta findByCpf(String cpf) {
		Optional<Conta> conta = contaRepository.findByCpf(cpf);
		if (conta.isPresent()) {
			return conta.get();
		}
		throw new ServiceException("Conta não encontrada");
	}

	public List<ContaDTO> findAll() {
		List<ContaDTO> contaParaRetorno = new ArrayList<ContaDTO>();
		List<Conta> contas = contaRepository.findAll();

		for (Conta conta : contas) {
			ContaDTO contaDTO = criarContaDTO(conta);
			if(conta.isStatus() == true) {
			contaParaRetorno.add(contaDTO);}
		}

		return contaParaRetorno;
	}

	private ContaDTO criarContaDTO(Conta conta) {
		ContaDTO contaDTO = new ContaDTO();
		contaDTO.setId(conta.getId());
		contaDTO.setNumero(conta.getNumero());
		contaDTO.setAgencia(conta.getAgencia());
		contaDTO.setCpf(conta.getCpf());
		contaDTO.setStatus(conta.isStatus());
		contaDTO.setDataCriacao(conta.getDataCriacao());
		contaDTO.setDataAtualizacao(conta.getDataAtualizacao());
		return contaDTO;
	}

	public void delete(Integer id) {
		this.contaRepository.deleteById(id);
	}

	public void edit(ContaDTO contaDTO) {
		Optional<Conta> contaParaAtualizar = contaRepository.findById(contaDTO.getId());
		if (contaParaAtualizar.isPresent()) {
			Integer id = contaDTO.getId();
			String numero = contaDTO.getNumero();
			String agencia = contaDTO.getAgencia();
			String cpf = contaDTO.getCpf();
			boolean status = contaDTO.isStatus();
			LocalDate dataCriacao = contaDTO.getDataCriacao();
			LocalDate dataAtualizacao = contaDTO.getDataAtualizacao();	
			contaRepository.editById(numero, agencia, cpf, status, dataCriacao, dataAtualizacao, id);	
		}
		throw new ServiceException("Conta não encontrada");
	}


	public ContaDTO findById(Integer id) {
		Optional<Conta> conta = contaRepository.findById(id);
		if (conta.isPresent()) {
			ContaDTO contaDTO = criarContaDTO(conta.get());
			return contaDTO;
		}
		throw new ServiceException("Conta não encontrada");
	}

}