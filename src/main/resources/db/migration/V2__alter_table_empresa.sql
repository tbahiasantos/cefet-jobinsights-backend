CREATE TABLE IF NOT EXISTS db_jobinsights.tb_setor
(
	setor_id bigserial NOT NULL,
	setor_nome character varying(50) NOT NULL,
    CONSTRAINT setor_pk PRIMARY KEY (setor_id)
);

ALTER TABLE IF EXISTS db_jobinsights.tb_empresa
	ADD COLUMN setor_id bigint NOT NULL;
	
ALTER TABLE IF EXISTS db_jobinsights.tb_empresa
    ADD CONSTRAINT fk_empresa_setor FOREIGN KEY (setor_id)
    REFERENCES db_jobinsights.tb_setor (setor_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;