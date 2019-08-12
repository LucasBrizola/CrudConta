package br.com.loja.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.loja.domain.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

	@Query("SELECT c FROM Conta c WHERE c.cpf = :cpf and c.status = true")
	Optional<Conta> findByCpf(@Param("cpf") String cpf);
	
	@Query("UPDATE Conta SET status = 0 WHERE id = :id")
	void deleteById(@Param("id") Integer id);
	
	@Query("UPDATE Conta set numero = :numero, agencia = :agencia, cpf = :cpf, status = :status, dataCriacao = :dataCriacao, dataAtualizacao = :dataAtualizacao where id = :id")
	void editById(@Param("numero") String numero, @Param("agencia") String agencia,
			@Param("cpf") String cpf, @Param("status") boolean status, 
			@Param("dataCriacao") LocalDate dataCriacao, @Param("dataAtualizacao") LocalDate dataAtualizacao,
			@Param("id") Integer id);
}