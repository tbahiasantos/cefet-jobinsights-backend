package br.com.taugs.jobinsights.enums;

import lombok.Getter;

@Getter
public enum OrderEnum {

	ASC("ASC"), //
	DESC("DESC");

	private final String order;

	private OrderEnum(String order) {
		this.order = order;
	}

}
