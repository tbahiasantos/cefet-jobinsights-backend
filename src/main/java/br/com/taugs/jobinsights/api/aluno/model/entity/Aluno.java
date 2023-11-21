package br.com.taugs.jobinsights.api.aluno.model.entity;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.taugs.jobinsights.api.avaliacao.model.entity.Avaliacao;
import br.com.taugs.jobinsights.api.cargo.model.entity.Cargo;
import br.com.taugs.jobinsights.api.curso.model.entity.Curso;
import br.com.taugs.jobinsights.api.salario.model.entity.Salario;
import br.com.taugs.jobinsights.api.usuario.model.entity.Usuario;
import br.com.taugs.jobinsights.api.vagaaluno.model.entity.VagaAluno;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_aluno", schema = "db_jobinsights")
@PrimaryKeyJoinColumn(name = "aluno_id")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Aluno extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5193235361507633633L;

	@Column(name = "aluno_ano_ingresso")
	private Timestamp anoIngresso;

	@Column(name = "cargo_id")
	private Long idCargo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cargo_id", insertable = false, updatable = false)
	private Cargo cargo;

	@Column(name = "curso_id")
	private Long idCurso;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "curso_id", insertable = false, updatable = false)
	private Curso curso;

	@Column(name = "aluno_telefone")
	private String telefone;

	@Column(name = "aluno_celular")
	private String celular;

	@Column(name = "aluno_ano_formatura")
	private Timestamp anoFormatura;

	@JsonManagedReference("fk_salario_aluno")
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Salario> salarios;

	@JsonManagedReference("fk_avaliacao_aluno")
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Avaliacao> avaliacoes;

	@JsonManagedReference("fk_vagas_aluno_aluno")
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<VagaAluno> listaVagasCandidatadas;

}
