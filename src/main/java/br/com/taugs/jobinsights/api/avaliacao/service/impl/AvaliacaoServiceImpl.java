package br.com.taugs.jobinsights.api.avaliacao.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taugs.jobinsights.api.avaliacao.model.dto.AvaliacaoFilterDTO;
import br.com.taugs.jobinsights.api.avaliacao.model.entity.Avaliacao;
import br.com.taugs.jobinsights.api.avaliacao.repository.AvaliacaoRepository;
import br.com.taugs.jobinsights.api.avaliacao.service.AvaliacaoService;
import br.com.taugs.jobinsights.utils.SortUtils;
import br.com.taugs.jobinsights.utils.StringUtils;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class AvaliacaoServiceImpl implements AvaliacaoService {

	private final AvaliacaoRepository repository;

	@Autowired
	public AvaliacaoServiceImpl(AvaliacaoRepository repository) {
		this.repository = repository;
	}

	@Override
	public Avaliacao salvar(Avaliacao entity) {
		entity.setDataAvaliacao(LocalDate.now());
		return this.repository.save(entity);
	}

	@Override
	public List<Avaliacao> listarPorEmpresa(Long idEmpresa) {
		return this.repository.findAllByIdEmpresa(idEmpresa);
	}

	@Override
	public List<Avaliacao> listarPorUsuario(Long idUsuario) {
		return this.repository.findAllByIdAluno(idUsuario);
	}

	@Override
	public List<Avaliacao> listarPorFiltro(AvaliacaoFilterDTO filtro) {
		filtro.setCargo(StringUtils.returnForLikeSearch(filtro.getCargo()));
		if (StringUtils.isBlank(filtro.getOrderBy())) {
			filtro.setOrderBy("dataAvaliacao");
		}
		if (filtro.getRangeDate() != null) {
			filtro.setDataFim(LocalDate.now().minusDays(filtro.getRangeDate()));
		}
		List<Avaliacao> response = this.repository.findByFilter(filtro, SortUtils.getSort("avaliacao", filtro));
		response.forEach(avaliacao -> {
			if (avaliacao.getAluno().getCargo() != null) {
				avaliacao.setCargoAluno(avaliacao.getAluno().getCargo().getNome());
			}
		});
		return response;
	}

	@Override
	public List<Avaliacao> listAll() {
		return this.listAll();
	}

}
