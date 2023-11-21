package br.com.taugs.jobinsights.api.cargo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.taugs.jobinsights.api.cargo.model.entity.Cargo;
import br.com.taugs.jobinsights.api.cargo.service.CargoService;
import br.com.taugs.jobinsights.utils.RestMapping;

@CrossOrigin("*")
@RestController
@RequestMapping("/cargo")
public class CargoController {

	@Autowired
	private CargoService service;

	@PostMapping(value = RestMapping.SALVAR)
	public ResponseEntity<Cargo> salvar(@RequestBody Cargo entity) {
		return ResponseEntity.ok(service.salvar(entity));
	}

	@GetMapping(value = RestMapping.LISTAR_TODOS)
	public ResponseEntity<List<Cargo>> listar() {
		return ResponseEntity.ok(service.listAll());
	}

}
