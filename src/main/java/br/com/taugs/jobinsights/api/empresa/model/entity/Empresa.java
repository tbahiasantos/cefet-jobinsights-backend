package br.com.taugs.jobinsights.api.empresa.model.entity;

import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.taugs.jobinsights.api.avaliacao.model.entity.Avaliacao;
import br.com.taugs.jobinsights.api.salario.model.entity.Salario;
import br.com.taugs.jobinsights.api.setor.model.entity.Setor;
import br.com.taugs.jobinsights.api.usuario.model.entity.Usuario;
import br.com.taugs.jobinsights.api.vaga.model.entity.Vaga;
import br.com.taugs.jobinsights.enums.TamanhoEmpresaEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_empresa", schema = "db_jobinsights")
@PrimaryKeyJoinColumn(name = "empresa_id")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Empresa extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2200966995193231022L;

	@Column(name = "empresa_descricao")
	private String descricao;

	@Column(name = "empresa_tamanho")
	private Integer tamanho;

	@Column(name = "setor_id")
	private Long idSetor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "setor_id", insertable = false, updatable = false)
	private Setor setor;

	@JsonManagedReference("fk_salario_empresa")
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Salario> salarios;

	@JsonManagedReference("fk_avaliacao_empresa")
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Avaliacao> avaliacoes;

	@JsonManagedReference("fk_vaga_empresa")
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Vaga> vagas;

	@Transient
	private String tamanhoStr;

	public String getTamanhoStr() {
		return TamanhoEmpresaEnum.getDescricaoByTamanho(this.tamanho);
	}

}
