package br.com.taugs.jobinsights.api.vagaaluno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taugs.jobinsights.api.factory.VagaFactory;
import br.com.taugs.jobinsights.api.vaga.model.dto.VagaResponseDTO;
import br.com.taugs.jobinsights.api.vagaaluno.model.entity.VagaAluno;
import br.com.taugs.jobinsights.api.vagaaluno.repository.VagaAlunoRepository;
import br.com.taugs.jobinsights.api.vagaaluno.service.VagaAlunoService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class VagaAlunoServiceImpl implements VagaAlunoService {

	private final VagaAlunoRepository repository;

	@Autowired
	public VagaAlunoServiceImpl(VagaAlunoRepository repository) {
		this.repository = repository;
	}

	@Override
	public VagaAluno salvar(VagaAluno entity) {
		return this.repository.save(entity);
	}

	@Override
	public List<VagaAluno> listAll() {
		return this.repository.findAll();
	}

	@Override
	public List<VagaResponseDTO> findByIdAluno(Long idAluno) {
		return VagaFactory.gerarListaVagas(this.repository.findByAlunoId(idAluno));
	}

}
