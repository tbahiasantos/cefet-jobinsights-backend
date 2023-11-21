package br.com.taugs.jobinsights.api.empresa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taugs.jobinsights.api.empresa.model.dto.EmpresaFilterDTO;
import br.com.taugs.jobinsights.api.empresa.model.dto.EmpresaResponseDTO;
import br.com.taugs.jobinsights.api.empresa.model.entity.Empresa;
import br.com.taugs.jobinsights.api.empresa.repository.EmpresaRepository;
import br.com.taugs.jobinsights.api.empresa.service.EmpresaService;
import br.com.taugs.jobinsights.api.factory.EmpresaFactory;
import br.com.taugs.jobinsights.utils.SortUtils;
import br.com.taugs.jobinsights.utils.StringUtils;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmpresaServiceImpl implements EmpresaService {

	private final EmpresaRepository repository;

	@Autowired
	public EmpresaServiceImpl(EmpresaRepository repository) {
		this.repository = repository;
	}

	@Override
	public Empresa salvar(Empresa entity) {
		return this.repository.save(entity);
	}

	@Override
	public List<Empresa> listAll() {
		return this.repository.findAll();
	}

	@Override
	public List<EmpresaResponseDTO> findByFilter(EmpresaFilterDTO filter) {
		filter.setNome(StringUtils.returnForLikeSearch(filter.getNome()));
		filter.setSetor(StringUtils.returnForLikeSearch(filter.getSetor()));
		return EmpresaFactory.gerarListaEmpresas(this.repository.findByFilter(filter, SortUtils.getSort("empresa", filter)));
	}

	@Override
	public Empresa findById(Long id) {
		Optional<Empresa> empresaOp = this.repository.findById(id);
		if (empresaOp.isPresent()) {
			return empresaOp.get();
		}
		return null;
	}

}
