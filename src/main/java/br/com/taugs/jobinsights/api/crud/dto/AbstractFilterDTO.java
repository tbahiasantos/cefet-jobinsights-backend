package br.com.taugs.jobinsights.api.crud.dto;

import br.com.taugs.jobinsights.enums.OrderEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractFilterDTO {

	private String orderBy;
	private OrderEnum order;
}
