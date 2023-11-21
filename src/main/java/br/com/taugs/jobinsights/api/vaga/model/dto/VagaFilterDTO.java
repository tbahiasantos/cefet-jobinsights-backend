package br.com.taugs.jobinsights.api.vaga.model.dto;

import java.math.BigDecimal;

import br.com.taugs.jobinsights.api.crud.dto.AbstractFilterDTO;
import br.com.taugs.jobinsights.enums.TipoVagaEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VagaFilterDTO extends AbstractFilterDTO {

	private String cargo;
	private String empresa;
	private BigDecimal salario;
	private Integer notaEmpresa;
	private Integer rangeDate;
	private TipoVagaEnum tipoVaga;

}
