package br.com.taugs.jobinsights.api.setor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taugs.jobinsights.api.setor.model.entity.Setor;
import br.com.taugs.jobinsights.api.setor.repository.SetorRepository;
import br.com.taugs.jobinsights.api.setor.service.SetorService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SetorServiceImpl implements SetorService {

	private final SetorRepository repository;

	@Autowired
	public SetorServiceImpl(SetorRepository repository) {
		this.repository = repository;
	}

	@Override
	public Setor salvar(Setor entity) {
		return this.repository.save(entity);
	}

	@Override
	public List<Setor> listAll() {
		return this.repository.findAll();
	}

}
