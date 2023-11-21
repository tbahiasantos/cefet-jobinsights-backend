package br.com.taugs.jobinsights.api.confirmation.service;

import br.com.taugs.jobinsights.api.usuario.model.entity.Usuario;

public interface ConfirmationService {

	Usuario confirmar(String encodeLogin);

}
