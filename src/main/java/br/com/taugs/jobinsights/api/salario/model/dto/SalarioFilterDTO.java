package br.com.taugs.jobinsights.api.salario.model.dto;

import br.com.taugs.jobinsights.api.crud.dto.AbstractFilterDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalarioFilterDTO extends AbstractFilterDTO {

	private String cargo;
	private Long idEmpresa;

}
