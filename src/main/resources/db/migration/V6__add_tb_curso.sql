CREATE TABLE IF NOT EXISTS db_jobinsights.tb_curso
(
	curso_id bigserial NOT NULL,
	curso_nome character varying(50) NOT NULL,
    CONSTRAINT curso_pk PRIMARY KEY (curso_id)
);

ALTER TABLE IF EXISTS db_jobinsights.tb_aluno
	ADD COLUMN curso_id bigint NOT NULL;
	
ALTER TABLE IF EXISTS db_jobinsights.tb_aluno
	ADD COLUMN aluno_telefone character varying(14);
	
ALTER TABLE IF EXISTS db_jobinsights.tb_aluno
	ADD COLUMN aluno_celular character varying(16);
	
ALTER TABLE IF EXISTS db_jobinsights.tb_aluno
	ADD COLUMN aluno_ano_formatura timestamp;
	
ALTER TABLE IF EXISTS db_jobinsights.tb_aluno
    ADD CONSTRAINT fk_aluno_curso FOREIGN KEY (curso_id)
    REFERENCES db_jobinsights.tb_curso (curso_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
