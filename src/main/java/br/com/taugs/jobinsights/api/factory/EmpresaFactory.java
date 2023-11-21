package br.com.taugs.jobinsights.api.factory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.taugs.jobinsights.api.empresa.model.dto.EmpresaResponseDTO;
import br.com.taugs.jobinsights.enums.TamanhoEmpresaEnum;

public final class EmpresaFactory {

	private EmpresaFactory() {

	}

	public static List<EmpresaResponseDTO> gerarListaEmpresas(List<Map<String, Object>> listMap) {
		final ObjectMapper mapper = new ObjectMapper();
		return listMap.stream().map(map -> {
			EmpresaResponseDTO empresaResponseDTO = mapper.convertValue(map, EmpresaResponseDTO.class);
			empresaResponseDTO.setTamanhoStr(getDescricaoTamanho(empresaResponseDTO.getTamanho()));
			return empresaResponseDTO;
		}).collect(Collectors.toList());
	}

	private static String getDescricaoTamanho(Integer tamanho) {
		return TamanhoEmpresaEnum.getDescricao(tamanho);
	}

}
