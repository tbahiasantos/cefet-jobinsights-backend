package br.com.taugs.jobinsights.api.empresa.service;

import java.util.List;

import br.com.taugs.jobinsights.api.crud.service.AbstractService;
import br.com.taugs.jobinsights.api.empresa.model.dto.EmpresaFilterDTO;
import br.com.taugs.jobinsights.api.empresa.model.dto.EmpresaResponseDTO;
import br.com.taugs.jobinsights.api.empresa.model.entity.Empresa;

public interface EmpresaService extends AbstractService<Empresa> {

	List<EmpresaResponseDTO> findByFilter(EmpresaFilterDTO filter);

	Empresa findById(Long id);

}
