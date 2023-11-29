package br.com.taugs.jobinsights.api.vaga.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
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
import br.com.taugs.jobinsights.utils.StringUtils;
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
		entity.setVagaAtiva(true);
		entity.setDataVaga(Timestamp.from(Instant.now()));
		return repository.save(entity);
	}

	@Override
	public List<Vaga> listAll() {
		return this.repository.findAll();
	}

	@Override
	public List<VagaResponseDTO> findByFilter(VagaFilterDTO filter) {
		if (StringUtils.isBlank(filter.getOrderBy())) {
			filter.setOrderBy("cargo.nome");
		}
		if (filter.getRangeDate() != null) {
			filter.setDataFim(LocalDate.now().minusDays(filter.getRangeDate()));
		}
		filter.setCargo(StringUtils.returnForLikeSearch(filter.getCargo()));
		filter.setEmpresa(StringUtils.returnForLikeSearch(filter.getEmpresa()));
		return VagaFactory.gerarListaVagas(this.repository.findByFilter(filter, SortUtils.getSort("vaga", filter)));
	}

	@Override
	public Vaga findById(Long id) {
		Optional<Vaga> vagaOp = this.repository.findById(id);
		if (vagaOp.isPresent()) {
			Vaga vaga = vagaOp.get();
			vaga.setNomeEmpresa(vaga.getEmpresa().getNome());
			return vaga;
		}
		return null;
	}

	@Override
	public Vaga editar(Vaga entity) {
		return this.repository.save(entity);
	}

}
