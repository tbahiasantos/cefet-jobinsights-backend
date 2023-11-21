package br.com.taugs.jobinsights.api.vagaaluno.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.taugs.jobinsights.api.aluno.model.entity.Aluno;
import br.com.taugs.jobinsights.api.vaga.model.entity.Vaga;
import br.com.taugs.jobinsights.api.vagaaluno.model.pk.VagaAlunoPK;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_vagas_aluno", schema = "db_jobinsights")
@IdClass(VagaAlunoPK.class)
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class VagaAluno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4950786902495331658L;

	@Id
	@Column(name = "aluno_id")
	private Long idAluno;

	@Id
	@Column(name = "vaga_id")
	private Long idVaga;

	@Column(name = "vagas_aluno_inscricao")
	private Timestamp dataInscricao;

	@JsonBackReference("fk_vagas_aluno_aluno")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aluno_id", insertable = false, updatable = false)
	private Aluno aluno;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vaga_id", insertable = false, updatable = false)
	private Vaga vaga;

}
