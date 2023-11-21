package br.com.taugs.jobinsights.api.empresa.model.dto;

import br.com.taugs.jobinsights.api.crud.dto.AbstractFilterDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaFilterDTO extends AbstractFilterDTO {

	private String nome;
	private String setor;
	private Integer tamanho;
	private Integer nota;

}
