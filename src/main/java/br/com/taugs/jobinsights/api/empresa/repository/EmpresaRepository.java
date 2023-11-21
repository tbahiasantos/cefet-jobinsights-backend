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
	        + "(SELECT SUM(avaliacao.nota)/COUNT(avaliacao) FROM Avaliacao avaliacao WHERE avaliacao.idEmpresa = empresa.id) as nota, " //
	        + "empresa.avaliacoes.size() as avaliacoes, "//
	        + "empresa.salarios.size() as salarios, " //
	        + "empresa.vagas.size() as vagas, " //
	        + "empresa.setor.nome as setor, " //
	        + "empresa.tamanho as tamanho " //
	        + "FROM Empresa empresa WHERE 1 = 1 " //
	        + "AND (UPPER(TRANSLATE(COALESCE(empresa.nome,''),'áãàâäçéèëêùûüúóôöïîíÁÀÂÄÃÇÉÈËÊÙÛÜÚÓÔÖÏÎÍ','aaaaaceeeeuuuuoooiiiAAAAACEEEEUUUUOOOIII')) LIKE :#{#filter.nome}) " //
	        + "AND (UPPER(TRANSLATE(COALESCE(empresa.setor.nome,''),'áãàâäçéèëêùûüúóôöïîíÁÀÂÄÃÇÉÈËÊÙÛÜÚÓÔÖÏÎÍ','aaaaaceeeeuuuuoooiiiAAAAACEEEEUUUUOOOIII')) LIKE :#{#filter.setor}) " //
	        + "AND (empresa.tamanho = :#{#filter.tamanho} OR :#{#filter.tamanho} IS NULL) " //
	        + "AND (:#{#filter.nota} IS NULL OR (SELECT SUM(avaliacao.nota)/COUNT(avaliacao) FROM Avaliacao avaliacao WHERE avaliacao.idEmpresa = empresa.id) >= :#{#filter.nota}) " //
	        + "ORDER BY :#{#sort} " //
	)
	List<Map<String, Object>> findByFilter(@Param("filter") EmpresaFilterDTO filter, @Param("sort") Sort sort);

}
