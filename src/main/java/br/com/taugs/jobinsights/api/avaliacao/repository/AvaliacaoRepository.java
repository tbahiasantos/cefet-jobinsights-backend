package br.com.taugs.jobinsights.api.avaliacao.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.taugs.jobinsights.api.avaliacao.model.dto.AvaliacaoFilterDTO;
import br.com.taugs.jobinsights.api.avaliacao.model.entity.Avaliacao;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

	List<Avaliacao> findAllByIdEmpresa(Long idEmpresa);

	List<Avaliacao> findAllByIdAluno(Long idAluno);

	@Query( //
	"SELECT avaliacao FROM Avaliacao avaliacao " //
	        + "JOIN FETCH avaliacao.aluno aluno " //
	        + "JOIN FETCH aluno.cargo cargo " //
	        + "WHERE 1 = 1 " //
	        + "AND (UPPER(TRANSLATE(COALESCE(cargo.nome,''),'áãàâäçéèëêùûüúóôöïîíÁÀÂÄÃÇÉÈËÊÙÛÜÚÓÔÖÏÎÍ','aaaaaceeeeuuuuoooiiiAAAAACEEEEUUUUOOOIII')) LIKE :#{#filter.cargo}) " //
	        + "AND (avaliacao.nota = :#{#filter.nota} OR :#{#filter.nota} IS NULL) " //
	        + "AND (avaliacao.idEmpresa = :#{#filter.idEmpresa}) "//
	        + "AND (:#{#filter.rangeDate} IS NULL OR avaliacao.dataAvaliacao BETWEEN CURRENT_DATE AND :#{#filter.dataFim}) " //
	        + "ORDER BY :#{#sort} " //
	)
	List<Avaliacao> findByFilter(@Param("filter") AvaliacaoFilterDTO filter, @Param("sort") Sort sort);

}
