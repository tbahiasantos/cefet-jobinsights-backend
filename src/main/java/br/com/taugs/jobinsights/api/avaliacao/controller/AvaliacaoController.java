package br.com.taugs.jobinsights.api.avaliacao.controller;

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

import br.com.taugs.jobinsights.api.avaliacao.model.dto.AvaliacaoFilterDTO;
import br.com.taugs.jobinsights.api.avaliacao.model.entity.Avaliacao;
import br.com.taugs.jobinsights.api.avaliacao.service.AvaliacaoService;
import br.com.taugs.jobinsights.utils.RestMapping;

@CrossOrigin("*")
@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

	private final AvaliacaoService service;

	@Autowired
	public AvaliacaoController(AvaliacaoService service) {
		this.service = service;
	}

	@PostMapping(value = RestMapping.SALVAR)
	public ResponseEntity<Avaliacao> salvar(@RequestBody Avaliacao entity) {
		return ResponseEntity.ok(this.service.salvar(entity));
	}

	@PostMapping(value = RestMapping.PESQUISAR)
	public ResponseEntity<List<Avaliacao>> pesquisar(@RequestBody AvaliacaoFilterDTO filter) {
		return ResponseEntity.ok(this.service.listarPorFiltro(filter));
	}

	@GetMapping(value = "/listar/{id}")
	public ResponseEntity<List<Avaliacao>> pesquisar(@PathVariable("id") Long idEmpresa) {
		return ResponseEntity.ok(this.service.listarPorEmpresa(idEmpresa));
	}
}
