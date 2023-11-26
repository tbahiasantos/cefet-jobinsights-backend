package br.com.taugs.jobinsights.api.empresa.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.taugs.jobinsights.api.empresa.model.dto.EmpresaFilterDTO;
import br.com.taugs.jobinsights.api.empresa.model.entity.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	@Query("SELECT empresa.nome as nome, " //
	        + "empresa.id as id, " //
	        + "AVG(avaliacao.nota) as nota, " //
	        + "COUNT(DISTINCT avaliacao) as avaliacoes, "//
	        + "COUNT(DISTINCT salario) as salarios, " //
	        + "COUNT(DISTINCT vaga) as vagas, " //
	        + "empresa.setor.nome as setor, " //
	        + "empresa.tamanho as tamanho " //
	        + "FROM Empresa empresa " //
	        + "LEFT JOIN empresa.avaliacoes avaliacao " //
	        + "LEFT JOIN empresa.salarios salario " //
	        + "LEFT JOIN empresa.vagas vaga " //
	        + "WHERE 1 = 1 " //
	        + "AND (UPPER(TRANSLATE(COALESCE(empresa.nome,''),'áãàâäçéèëêùûüúóôöïîíÁÀÂÄÃÇÉÈËÊÙÛÜÚÓÔÖÏÎÍ','aaaaaceeeeuuuuoooiiiAAAAACEEEEUUUUOOOIII')) LIKE :#{#filter.nome}) " //
	        + "AND (UPPER(TRANSLATE(COALESCE(empresa.setor.nome,''),'áãàâäçéèëêùûüúóôöïîíÁÀÂÄÃÇÉÈËÊÙÛÜÚÓÔÖÏÎÍ','aaaaaceeeeuuuuoooiiiAAAAACEEEEUUUUOOOIII')) LIKE :#{#filter.setor}) " //
	        + "AND (empresa.tamanho = :#{#filter.tamanho} OR :#{#filter.tamanho} IS NULL) " //
	        + "AND (:#{#filter.nota} IS NULL OR (SELECT SUM(avaliacao.nota)/COUNT(avaliacao) FROM Avaliacao avaliacao WHERE avaliacao.idEmpresa = empresa.id) >= :#{#filter.nota}) " //
	        + "GROUP BY empresa.id, empresa.nome, empresa.setor.nome, empresa.tamanho " //
	        + "ORDER BY :#{#sort} " //
	)
	List<Map<String, Object>> findByFilter(@Param("filter") EmpresaFilterDTO filter, @Param("sort") Sort sort);

}
