package br.com.neighbors.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Persistence {

	@PersistenceContext(unitName="neighbors")
    protected EntityManager em;
}
