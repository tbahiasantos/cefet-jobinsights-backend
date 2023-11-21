package br.com.taugs.jobinsights.api.avaliacao.service;

import java.util.List;

import br.com.taugs.jobinsights.api.avaliacao.model.dto.AvaliacaoFilterDTO;
import br.com.taugs.jobinsights.api.avaliacao.model.entity.Avaliacao;
import br.com.taugs.jobinsights.api.crud.service.AbstractService;

public interface AvaliacaoService extends AbstractService<Avaliacao> {

	List<Avaliacao> listarPorEmpresa(Long idEmpresa);

	List<Avaliacao> listarPorUsuario(Long idUsuario);

	List<Avaliacao> listarPorFiltro(AvaliacaoFilterDTO filtro);

}
