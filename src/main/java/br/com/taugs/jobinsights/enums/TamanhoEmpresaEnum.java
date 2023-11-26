package br.com.taugs.jobinsights.enums;

import lombok.Getter;

@Getter
public enum TamanhoEmpresaEnum {

	EMPR_MINI(1, "< 500 Funcionários"), //
	EMPR_PEQUENA(2, "500 - 1000 Funcionários"), //
	EMPR_MEDIA(3, "1000 - 5000 Funcionários"), //
	EMPR_GRANDE(4, "5000 - 10000 Funcionários"), //
	EMPR_GIGANTE(5, "> 10000 Funcionários");

	private final Integer tamanho;
	private final String descricao;

	private TamanhoEmpresaEnum(Integer tamanho, String descricao) {
		this.descricao = descricao;
		this.tamanho = tamanho;
	}

	public static String getDescricaoByTamanho(Integer tamanho) {
		for (TamanhoEmpresaEnum e : values()) {
			if (e.getTamanho().equals(tamanho)) {
				return e.getDescricao();
			}
		}
		return "";
	}

}
