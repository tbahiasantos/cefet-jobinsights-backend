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
	        + "AND (TO_DATE(TO_CHAR(avaliacao.dataAvaliacao, 'YYYY-MM-DD'), 'dd/mm/yy') = TO_DATE(TO_CHAR(:#{#filter.dataAvaliacao}, 'YYYY-MM-DD'), 'dd/mm/yy') OR :#{#filter.dataAvaliacao} IS NULL) " //
	        + "ORDER BY :#{#sort} " //
	)
	List<Avaliacao> findByFilter(@Param("filter") AvaliacaoFilterDTO filter, @Param("sort") Sort sort);

}
