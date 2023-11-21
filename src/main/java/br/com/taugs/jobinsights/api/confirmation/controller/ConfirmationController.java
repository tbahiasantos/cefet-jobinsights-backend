package br.com.taugs.jobinsights.api.confirmation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.taugs.jobinsights.api.confirmation.service.ConfirmationService;
import br.com.taugs.jobinsights.api.usuario.model.entity.Usuario;

@CrossOrigin("*")
@RestController
@RequestMapping("/confirmation")
public class ConfirmationController {

	private final ConfirmationService service;

	@Autowired
	public ConfirmationController(ConfirmationService service) {
		this.service = service;
	}

	@GetMapping(value = "confirmar/{loginEncode}")
	public ResponseEntity<Usuario> confirmar(@PathVariable("loginEncode") String loginEncode) {
		System.out.println("Requisição para confirmar: " + loginEncode);
		Usuario usuario = service.confirmar(loginEncode);
		if (usuario == null) {
			return ResponseEntity.of(Optional.empty());
		}
		return ResponseEntity.ok(usuario);
	}

}
