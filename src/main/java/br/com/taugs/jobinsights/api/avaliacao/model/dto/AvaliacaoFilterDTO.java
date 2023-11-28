package br.com.taugs.jobinsights.api.avaliacao.model.dto;

import java.time.LocalDate;

import br.com.taugs.jobinsights.api.crud.dto.AbstractFilterDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AvaliacaoFilterDTO extends AbstractFilterDTO {

	private Integer nota;
	private String cargo;
	private LocalDate dataAvaliacao;
	private LocalDate dataFim;
	private Long idEmpresa;
	private Integer rangeDate;
}
