ALTER TABLE IF EXISTS db_jobinsights.tb_salario
	ADD COLUMN cargo_id bigint NOT NULL;
	
ALTER TABLE IF EXISTS db_jobinsights.tb_salario
    ADD CONSTRAINT fk_salario_cargo FOREIGN KEY (cargo_id)
    REFERENCES db_jobinsights.tb_cargo (cargo_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;