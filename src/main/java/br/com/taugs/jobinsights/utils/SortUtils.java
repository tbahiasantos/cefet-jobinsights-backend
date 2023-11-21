package br.com.taugs.jobinsights.utils;

import org.springframework.data.domain.Sort;

import br.com.taugs.jobinsights.api.crud.dto.AbstractFilterDTO;
import br.com.taugs.jobinsights.enums.OrderEnum;

public final class SortUtils {

	private SortUtils() {

	}

	public static Sort getSort(String entity, AbstractFilterDTO filter) {
		Sort sort = Sort.by(entity.concat("." + filter.getOrderBy()));
		return filter.getOrder().equals(OrderEnum.ASC) ? sort.ascending() : sort.descending();
	}

}
