package br.com.taugs.jobinsights.api.salario.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.taugs.jobinsights.api.aluno.model.entity.Aluno;
import br.com.taugs.jobinsights.api.empresa.model.entity.Empresa;
import br.com.taugs.jobinsights.api.salario.model.pk.SalarioPK;
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
@Table(name = "tb_salario", schema = "db_jobinsights")
@IdClass(SalarioPK.class)
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Salario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5259928437195644487L;

	@Id
	@Column(name = "aluno_id")
	private Long idAluno;

	@Id
	@Column(name = "empresa_id")
	private Long idEmpresa;

	@Column(name = "salario_valor")
	private BigDecimal valor;

	@JsonBackReference("fk_salario_aluno")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aluno_id", insertable = false, updatable = false)
	private Aluno aluno;

	@JsonBackReference("fk_salario_empresa")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empresa_id", insertable = false, updatable = false)
	private Empresa empresa;

}
