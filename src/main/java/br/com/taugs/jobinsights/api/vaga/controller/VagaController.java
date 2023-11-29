package br.com.taugs.jobinsights.api.vaga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.taugs.jobinsights.api.cargo.model.entity.Cargo;
import br.com.taugs.jobinsights.api.cargo.service.CargoService;
import br.com.taugs.jobinsights.api.vaga.model.dto.VagaFilterDTO;
import br.com.taugs.jobinsights.api.vaga.model.dto.VagaResponseDTO;
import br.com.taugs.jobinsights.api.vaga.model.entity.Vaga;
import br.com.taugs.jobinsights.api.vaga.service.VagaService;
import br.com.taugs.jobinsights.utils.RestMapping;

@CrossOrigin("*")
@RestController
@RequestMapping("/vaga")
public class VagaController {

	private final VagaService service;
	private final CargoService cargoService;

	@Autowired
	public VagaController(//
	        VagaService service, //
	        CargoService cargoService//
	) {
		this.service = service;
		this.cargoService = cargoService;
	}

	@PostMapping(value = RestMapping.SALVAR)
	public ResponseEntity<Vaga> salvar(@RequestBody Vaga entity) {
		if (entity.getIdCargo() == -1) {
			Cargo cargo = this.cargoService.salvar(entity.getCargo());
			entity.setIdCargo(cargo.getId());
		}
		return ResponseEntity.ok(this.service.salvar(entity));
	}

	@PostMapping(value = RestMapping.EDITAR)
	public ResponseEntity<Vaga> editar(@RequestBody Vaga entity) {
		if (entity.getIdCargo() == -1) {
			Cargo cargo = this.cargoService.salvar(entity.getCargo());
			entity.setIdCargo(cargo.getId());
		}
		return ResponseEntity.ok(this.service.editar(entity));
	}

	@PostMapping(value = RestMapping.PESQUISAR)
	public ResponseEntity<List<VagaResponseDTO>> pesquisar(@RequestBody VagaFilterDTO filter) {
		return ResponseEntity.ok(this.service.findByFilter(filter));
	}

	@GetMapping(value = RestMapping.DETALHAR)
	public ResponseEntity<Vaga> pesquisar(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.service.findById(id));
	}

}
