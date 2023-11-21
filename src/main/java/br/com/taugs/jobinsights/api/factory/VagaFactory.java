package br.com.taugs.jobinsights.api.factory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.taugs.jobinsights.api.vaga.model.dto.VagaResponseDTO;
import br.com.taugs.jobinsights.enums.TipoVagaEnum;

public final class VagaFactory {

	private VagaFactory() {

	}

	public static List<VagaResponseDTO> gerarListaVagas(List<Map<String, Object>> listMap) {
		final ObjectMapper mapper = new ObjectMapper();
		return listMap.stream().map(map -> {
			VagaResponseDTO vagaResponseDTO = mapper.convertValue(map, VagaResponseDTO.class);
			vagaResponseDTO.setTipoVaga(getTipoVaga(vagaResponseDTO.getTipoVaga()));
			return vagaResponseDTO;
		}).collect(Collectors.toList());
	}

	private static String getTipoVaga(String tipoVaga) {
		return Integer.valueOf(tipoVaga).equals(TipoVagaEnum.VAGA_EMPREGO.getTipoVaga()) ? "Emprego" : "Estágio";
	}

}
