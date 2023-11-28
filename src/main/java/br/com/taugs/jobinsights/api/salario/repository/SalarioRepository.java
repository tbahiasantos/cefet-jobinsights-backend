package br.com.taugs.jobinsights.api.salario.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.taugs.jobinsights.api.salario.model.dto.SalarioFilterDTO;
import br.com.taugs.jobinsights.api.salario.model.entity.Salario;

@Repository
public interface SalarioRepository extends JpaRepository<Salario, Long> {

	@Query("SELECT " //
	        + "cargo.nome as cargo, " //
	        + "MAX(salario.valor) as maior, " //
	        + "MIN(salario.valor) as menor, " //
	        + "COUNT(salario.id) as total " //
	        + "FROM Salario salario " //
	        + "JOIN salario.cargo cargo " //
	        + "JOIN salario.empresa empresa " //
	        + "WHERE 1 = 1 " //
	        + "AND (UPPER(TRANSLATE(COALESCE(cargo.nome,''),'áãàâäçéèëêùûüúóôöïîíÁÀÂÄÃÇÉÈËÊÙÛÜÚÓÔÖÏÎÍ','aaaaaceeeeuuuuoooiiiAAAAACEEEEUUUUOOOIII')) LIKE :#{#filter.cargo}) " //
	        + "AND (empresa.id = :#{#filter.idEmpresa}) " //
	        + "GROUP BY cargo.nome " + "ORDER BY :#{#sort} " //
	)
	List<Map<String, Object>> findByFilter(@Param("filter") SalarioFilterDTO filter, @Param("sort") Sort sort);

}
