package br.com.taugs.jobinsights.api.setor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.taugs.jobinsights.api.setor.model.entity.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {

}
