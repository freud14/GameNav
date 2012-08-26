
package org.bitducks.gamenav.entityutil;

import java.util.List;

import org.bitducks.gamenav.ejb.entity.Joueur;

public interface JoueurService {

	List<Joueur> getUserByLoginOrEmail(String login, String email);
}
