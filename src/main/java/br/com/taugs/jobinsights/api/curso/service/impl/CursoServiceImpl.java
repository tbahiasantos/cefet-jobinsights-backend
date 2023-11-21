package br.com.taugs.jobinsights.api.curso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taugs.jobinsights.api.curso.model.entity.Curso;
import br.com.taugs.jobinsights.api.curso.repository.CursoRepository;
import br.com.taugs.jobinsights.api.curso.service.CursoService;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class CursoServiceImpl implements CursoService {

	private final CursoRepository repository;

	@Autowired
	public CursoServiceImpl(CursoRepository repository) {
		this.repository = repository;
	}

	@Override
	public Curso salvar(Curso entity) {
		return this.repository.save(entity);
	}

	@Override
	public List<Curso> listAll() {
		return this.repository.findAll();
	}

}
