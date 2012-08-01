package org.bitducks.gamenav.ejb.session.entityutil.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.bitducks.gamenav.ejb.entity.Joueur;
import org.bitducks.gamenav.ejb.session.entityutil.JoueurService;
import org.bitducks.gamenav.ejb.util.Util;

@Stateless
public class JoueurServiceBean implements JoueurService {

	public static final String GET_JOUEUR = "Joueur.getJoueur";

	@PersistenceContext(unitName = "GameNavPU")
	private EntityManager em;

	@Override
	public void create(int universId, Joueur joueur) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getJoueur(int universId, String login, String password) {
		Query query = this.em.createNamedQuery(GET_JOUEUR);
		query.setParameter("universId", Integer.valueOf(universId));
		query.setParameter("login", login);
		query.setParameter("password", Util.sha256(password));

		return (Object[]) query.getSingleResult();
	}
}
