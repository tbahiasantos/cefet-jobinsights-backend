package br.com.taugs.jobinsights.api.salario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taugs.jobinsights.api.factory.SalarioFactory;
import br.com.taugs.jobinsights.api.salario.model.dto.SalarioFilterDTO;
import br.com.taugs.jobinsights.api.salario.model.dto.SalarioResponseDTO;
import br.com.taugs.jobinsights.api.salario.model.entity.Salario;
import br.com.taugs.jobinsights.api.salario.repository.SalarioRepository;
import br.com.taugs.jobinsights.api.salario.service.SalarioService;
import br.com.taugs.jobinsights.utils.SortUtils;
import br.com.taugs.jobinsights.utils.StringUtils;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SalarioServiceImpl implements SalarioService {

	private final SalarioRepository repository;

	@Autowired
	public SalarioServiceImpl(SalarioRepository repository) {
		this.repository = repository;
	}

	@Override
	public Salario salvar(Salario entity) {
		return this.repository.save(entity);
	}

	@Override
	public List<Salario> listAll() {
		return this.repository.findAll();
	}

	@Override
	public List<SalarioResponseDTO> listByFilter(SalarioFilterDTO filter) {
		filter.setCargo(StringUtils.returnForLikeSearch(filter.getCargo()));
		return SalarioFactory.gerarListaSalario(repository.findByFilter(filter, SortUtils.getSort("salario", filter)));
	}

}
