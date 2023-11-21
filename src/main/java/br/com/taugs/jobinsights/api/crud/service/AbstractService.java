package br.com.taugs.jobinsights.api.crud.service;

import java.util.List;

public interface AbstractService<E> {

	E salvar(E entity);

	List<E> listAll();

}
