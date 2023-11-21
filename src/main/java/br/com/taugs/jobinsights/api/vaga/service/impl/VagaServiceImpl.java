package br.com.taugs.jobinsights.api.vaga.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taugs.jobinsights.api.factory.VagaFactory;
import br.com.taugs.jobinsights.api.vaga.model.dto.VagaFilterDTO;
import br.com.taugs.jobinsights.api.vaga.model.dto.VagaResponseDTO;
import br.com.taugs.jobinsights.api.vaga.model.entity.Vaga;
import br.com.taugs.jobinsights.api.vaga.repository.VagaRepository;
import br.com.taugs.jobinsights.api.vaga.service.VagaService;
import br.com.taugs.jobinsights.utils.SortUtils;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class VagaServiceImpl implements VagaService {

	private final VagaRepository repository;

	@Autowired
	public VagaServiceImpl(VagaRepository repository) {
		this.repository = repository;
	}

	@Override
	public Vaga salvar(Vaga entity) {
		return repository.save(entity);
	}

	@Override
	public List<Vaga> listAll() {
		return this.repository.findAll();
	}

	@Override
	public List<VagaResponseDTO> findByFilter(VagaFilterDTO filter) {
		return VagaFactory.gerarListaVagas(this.repository.findByFilter(filter, SortUtils.getSort("vaga", filter)));
	}

	@Override
	public Vaga findById(Long id) {
		Optional<Vaga> vagaOp = this.repository.findById(id);
		if (vagaOp.isPresent()) {
			return vagaOp.get();
		}
		return null;
	}

}
