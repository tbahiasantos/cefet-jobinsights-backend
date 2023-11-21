package br.com.taugs.jobinsights.api.factory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.taugs.jobinsights.api.salario.model.dto.SalarioResponseDTO;

public final class SalarioFactory {

	private SalarioFactory() {

	}

	public static List<SalarioResponseDTO> gerarListaSalario(List<Map<String, Object>> listMap) {
		final ObjectMapper mapper = new ObjectMapper();
		return listMap.stream().map(map -> {
			SalarioResponseDTO salarioResponseDTO = mapper.convertValue(map, SalarioResponseDTO.class);
			return salarioResponseDTO;
		}).collect(Collectors.toList());
	}

}
