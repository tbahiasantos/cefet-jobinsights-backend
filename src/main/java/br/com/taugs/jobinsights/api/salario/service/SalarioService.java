package br.com.taugs.jobinsights.api.salario.service;

import java.util.List;

import br.com.taugs.jobinsights.api.crud.service.AbstractService;
import br.com.taugs.jobinsights.api.salario.model.dto.SalarioFilterDTO;
import br.com.taugs.jobinsights.api.salario.model.dto.SalarioResponseDTO;
import br.com.taugs.jobinsights.api.salario.model.entity.Salario;

public interface SalarioService extends AbstractService<Salario> {

	List<SalarioResponseDTO> listByFilter(SalarioFilterDTO filter);

}
