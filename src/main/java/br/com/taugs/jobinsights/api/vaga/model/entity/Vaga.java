package br.com.taugs.jobinsights.api.vaga.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.taugs.jobinsights.api.cargo.model.entity.Cargo;
import br.com.taugs.jobinsights.api.empresa.model.entity.Empresa;
import br.com.taugs.jobinsights.enums.TipoVagaEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_vaga", schema = "db_jobinsights")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vaga implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2427265822998017223L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vaga_id")
	private Long id;

	@Column(name = "vaga_descricao")
	private String descricao;

	@Column(name = "vaga_salario")
	private BigDecimal salario;

	@Column(name = "vaga_tipo")
	private TipoVagaEnum tipoVaga;

	@Column(name = "cargo_id")
	private Long idCargo;

	@Column(name = "empresa_id")
	private Long idEmpresa;

	@Column(name = "vaga_data")
	private Timestamp dataVaga;

	@Column(name = "vaga_ativa")
	private Boolean vagaAtiva;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cargo_id", insertable = false, updatable = false)
	private Cargo cargo;

	@JsonBackReference("fk_vaga_empresa")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empresa_id", insertable = false, updatable = false)
	private Empresa empresa;

	@Transient
	private String nomeEmpresa;

}
