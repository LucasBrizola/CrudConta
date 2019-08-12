package br.com.loja.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.dto.ContaDTO;
import br.com.loja.service.ContaService;

@RestController
@RequestMapping(value = "banco")
public class ContaController {

	private ContaService contaService;

	@Autowired
	public ContaController(ContaService contaService) {
		this.contaService = contaService;
	}

	@GetMapping(value = "/conta")
	public ResponseEntity<List<ContaDTO>> obterConta() {
		List<ContaDTO> contas = contaService.findAll();
		return new ResponseEntity<List<ContaDTO>>(contas, HttpStatus.OK);
	}

	@GetMapping(value = "/conta/{id}")
	public ResponseEntity<ContaDTO> obterContaPorId(@PathVariable("id") Integer id) {
		ContaDTO conta = contaService.findById(id);
		return new ResponseEntity<ContaDTO>(conta, HttpStatus.OK);
	}

	@PostMapping(value = "/conta")
	public ResponseEntity<?> salvar(@RequestBody @Valid ContaDTO contaDTO) {
		this.contaService.save(contaDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(value = "conta/{id}")
	public ResponseEntity<ContaDTO> editarConta(@PathVariable("id") String id, @RequestBody @Valid ContaDTO contaDTO) {
		this.contaService.edit(contaDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/conta/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Integer id) {
		this.contaService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
