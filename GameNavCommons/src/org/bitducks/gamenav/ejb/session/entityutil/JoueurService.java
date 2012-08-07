package org.bitducks.gamenav.ejb.session.entityutil;

import javax.ejb.Remote;

import org.bitducks.gamenav.ejb.entity.Joueur;

@Remote
public interface JoueurService {
	void create(int universId, Joueur joueur);
	
	Object[] getJoueur(int universId, String nomUtilisateur, String motDePasse);
}
