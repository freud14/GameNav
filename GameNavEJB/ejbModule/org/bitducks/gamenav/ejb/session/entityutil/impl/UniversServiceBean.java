package org.bitducks.gamenav.ejb.session.entityutil.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.bitducks.gamenav.ejb.entity.Univers;
import org.bitducks.gamenav.ejb.session.entityutil.UniversService;

@Stateless
public class UniversServiceBean implements UniversService {

	public static final String FIND_ALL_UNIVERS = "Univers.findAll"; 
	
	@PersistenceContext(unitName = "GameNavPU")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Univers> getAllUnivers() {
		return this.em.createNamedQuery(FIND_ALL_UNIVERS).getResultList();
	}

}
