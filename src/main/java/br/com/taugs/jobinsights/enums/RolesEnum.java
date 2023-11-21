package br.com.taugs.jobinsights.enums;

import lombok.Getter;

@Getter
public enum RolesEnum {

	ALUNO_ROLE("ALUNO_ROLE"), //
	EMPRESA_ROLE("EMPRESA_ROLE");

	private final String role;

	private RolesEnum(String role) {
		this.role = role;
	}

}
