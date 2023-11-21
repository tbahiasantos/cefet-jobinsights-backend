package br.com.taugs.jobinsights.api.vagaaluno.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.taugs.jobinsights.api.vagaaluno.model.entity.VagaAluno;

@Repository
public interface VagaAlunoRepository extends JpaRepository<VagaAluno, Long> {

	@Query("SELECT " //
	        + "cargo.nome as cargo, " //
	        + "empresa.nome as nomeEmpresa, " //
	        + "vaga.salario as salario, " //
	        + "vaga.tipoVaga as tipoVaga " //
	        + "FROM VagaAluno vagaAluno " //
	        + "JOIN vagaAluno.vaga vaga " //
	        + "JOIN vaga.empresa empresa " //
	        + "JOIN vaga.cargo cargo " //
	        + "WHERE vagaAluno.idAluno = :idAluno " //
	        + "ORDER BY vagaAluno.dataInscricao DESC " //
	)
	List<Map<String, Object>> findByAlunoId(@Param("idAluno") Long idAluno);

}
