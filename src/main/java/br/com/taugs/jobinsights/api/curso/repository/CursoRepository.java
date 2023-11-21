package br.com.taugs.jobinsights.api.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.taugs.jobinsights.api.curso.model.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
