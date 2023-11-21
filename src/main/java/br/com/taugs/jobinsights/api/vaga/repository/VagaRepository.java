package br.com.taugs.jobinsights.api.vaga.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.taugs.jobinsights.api.vaga.model.dto.VagaFilterDTO;
import br.com.taugs.jobinsights.api.vaga.model.entity.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {

	@Query("SELECT " //
	        + "cargo.nome as cargo, " //
	        + "empresa.nome as nomeEmpresa, " //
	        + "vaga.salario as salario, " //
	        + "vaga.tipoVaga as tipoVaga " //
	        + "FROM Vaga vaga " //
	        + "JOIN vaga.empresa empresa " //
	        + "JOIN vaga.cargo cargo " //
	        + "WHERE 1 = 1 " //
	        + "AND (UPPER(TRANSLATE(COALESCE(cargo.nome,''),'áãàâäçéèëêùûüúóôöïîíÁÀÂÄÃÇÉÈËÊÙÛÜÚÓÔÖÏÎÍ','aaaaaceeeeuuuuoooiiiAAAAACEEEEUUUUOOOIII')) LIKE :#{#filter.cargo}) " //
	        + "AND (UPPER(TRANSLATE(COALESCE(empresa.nome,''),'áãàâäçéèëêùûüúóôöïîíÁÀÂÄÃÇÉÈËÊÙÛÜÚÓÔÖÏÎÍ','aaaaaceeeeuuuuoooiiiAAAAACEEEEUUUUOOOIII')) LIKE :#{#filter.empresa}) " //
	        + "AND ( (vaga.salario IS NOT NULL AND :#{#filter.salario} IS NOT NULL AND vaga.salario >= :#{#filter.salario}) OR (:#{#filter.salario} IS NULL OR vaga.salario IS NULL) ) " //
	        + "AND ( (SELECT SUM(avaliacao.nota)/COUNT(avaliacao) FROM Avaliacao avaliacao WHERE avaliacao.idEmpresa = empresa.id) >= :#{#filter.notaEmpresa} OR :#{#filter.notaEmpresa} IS NULL) " //
	        + "AND (TO_DATE(TO_CHAR(vaga.dataVaga, 'YYYY-MM-DD'), 'dd/mm/yy') <= TO_DATE(TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD') -:#{#filter.rageDate}, 'dd/mm/yy') OR :#{#filter.rageDate} IS NULL)" //
	        + "AND (vaga.tipoVaga = :#{#filter.tipoVaga} OR :#{#filter.tipoVaga} IS NULL) " //
	        + "ORDER BY :#{#sort}")
	List<Map<String, Object>> findByFilter(@Param("filter") VagaFilterDTO filter, @Param("sort") Sort sort);

}
