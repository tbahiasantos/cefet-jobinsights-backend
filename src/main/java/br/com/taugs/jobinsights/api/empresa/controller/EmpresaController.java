package br.com.taugs.jobinsights.api.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.taugs.jobinsights.api.empresa.model.dto.EmpresaFilterDTO;
import br.com.taugs.jobinsights.api.empresa.model.dto.EmpresaResponseDTO;
import br.com.taugs.jobinsights.api.empresa.model.entity.Empresa;
import br.com.taugs.jobinsights.api.empresa.service.EmpresaService;
import br.com.taugs.jobinsights.api.usuario.model.entity.Usuario;
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

	@GetMapping(value = RestMapping.DETALHAR)
	public ResponseEntity<Usuario> confirmar(@PathVariable("id") Long id) {
		Empresa empresa = service.findById(id);
		if (empresa == null) {
			return ResponseEntity.of(Optional.empty());
		}
		return ResponseEntity.ok(empresa);
	}

}
