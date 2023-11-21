package br.com.taugs.jobinsights.api.vagaaluno.service;

import java.util.List;

import br.com.taugs.jobinsights.api.crud.service.AbstractService;
import br.com.taugs.jobinsights.api.vaga.model.dto.VagaResponseDTO;
import br.com.taugs.jobinsights.api.vagaaluno.model.entity.VagaAluno;

public interface VagaAlunoService extends AbstractService<VagaAluno> {

	List<VagaResponseDTO> findByIdAluno(Long idAluno);

}
