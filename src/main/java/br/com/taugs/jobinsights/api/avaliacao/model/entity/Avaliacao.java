package br.com.taugs.jobinsights.api.avaliacao.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.taugs.jobinsights.api.aluno.model.entity.Aluno;
import br.com.taugs.jobinsights.api.avaliacao.model.pk.AvaliacaoPK;
import br.com.taugs.jobinsights.api.empresa.model.entity.Empresa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_avaliacao", schema = "db_jobinsights")
@IdClass(AvaliacaoPK.class)
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Avaliacao implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -969197415742304818L;

	@Id
	@Column(name = "aluno_id")
	private Long idAluno;

	@Id
	@Column(name = "empresa_id")
	private Long idEmpresa;

	@Column(name = "avaliacao_nota")
	private Integer nota;

	@Column(name = "avaliacao_titulo")
	private String titulo;

	@Column(name = "avaliacao_pros")
	private String pros;

	@Column(name = "avaliacao_contras")
	private String contra;

	@Column(name = "avaliacao_data")
	private Timestamp dataAvaliacao;

	@JsonBackReference("fk_avaliacao_aluno")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aluno_id", insertable = false, updatable = false)
	private Aluno aluno;

	@JsonBackReference("fk_avaliacao_empresa")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empresa_id", insertable = false, updatable = false)
	private Empresa empresa;

	@Transient
	private String cargoAluno;

}
