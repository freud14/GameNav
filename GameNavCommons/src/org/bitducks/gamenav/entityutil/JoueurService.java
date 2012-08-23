
package org.bitducks.gamenav.entityutil;

import org.bitducks.gamenav.ejb.entity.Joueur;

public interface JoueurService {

	void create(int universId, Joueur joueur);

	Object[] getJoueur(int universId, String nomUtilisateur, String motDePasse);
}
