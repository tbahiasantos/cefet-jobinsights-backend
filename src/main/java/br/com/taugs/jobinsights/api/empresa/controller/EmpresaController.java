package br.com.taugs.jobinsights.api.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.taugs.jobinsights.api.empresa.model.dto.EmpresaFilterDTO;
import br.com.taugs.jobinsights.api.empresa.model.dto.EmpresaResponseDTO;
import br.com.taugs.jobinsights.api.empresa.service.EmpresaService;
import br.com.taugs.jobinsights.utils.RestMapping;

@CrossOrigin("*")
@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	private final EmpresaService service;

	@Autowired
	public EmpresaController(EmpresaService service) {
		this.service = service;
	}

	@PostMapping(value = RestMapping.PESQUISAR)
	public ResponseEntity<List<EmpresaResponseDTO>> pesquisar(@RequestBody EmpresaFilterDTO filter) {
		return ResponseEntity.ok(this.service.findByFilter(filter));
	}

}
