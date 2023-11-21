package br.com.taugs.jobinsights.api.cargo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taugs.jobinsights.api.cargo.model.entity.Cargo;
import br.com.taugs.jobinsights.api.cargo.repository.CargoRepository;
import br.com.taugs.jobinsights.api.cargo.service.CargoService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CargoServiceImpl implements CargoService {

	private final CargoRepository repository;

	@Autowired
	public CargoServiceImpl(CargoRepository repository) {
		this.repository = repository;
	}

	@Override
	public Cargo salvar(Cargo entity) {
		return this.repository.save(entity);
	}

	@Override
	public List<Cargo> listAll() {
		return this.repository.findAll();
	}

}
