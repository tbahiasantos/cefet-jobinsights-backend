package br.com.taugs.jobinsights.enums;

import lombok.Getter;

@Getter
public enum TipoVagaEnum {

	VAGA_ESTAGIO(0), //
	VAGA_EMPREGO(1);

	private final Integer tipoVaga;

	private TipoVagaEnum(Integer tipoVaga) {
		this.tipoVaga = tipoVaga;
	}

}
