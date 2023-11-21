package br.com.taugs.jobinsights.mail.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class EmailRequestDTO {

	private String para;
	private String assunto;
	private String texto;

}
