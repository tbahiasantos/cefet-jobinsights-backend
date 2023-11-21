ALTER TABLE IF EXISTS db_jobinsights.tb_avaliacao
	ADD COLUMN avaliacao_data timestamp;
	
ALTER TABLE IF EXISTS db_jobinsights.tb_salario
	ADD COLUMN salario_data timestamp;
	
ALTER TABLE IF EXISTS db_jobinsights.tb_vaga
	ADD COLUMN vaga_data timestamp;
	
ALTER TABLE IF EXISTS db_jobinsights.tb_vagas_aluno
	ADD COLUMN vagas_aluno_inscricao timestamp;