
package org.bitducks.gamenav.entityutil;

import java.util.List;

import org.bitducks.gamenav.ejb.entity.JoueurDroit;

public interface JoueurDroitService {

	List<JoueurDroit> getJoueurDroitsByLogin(String login);
}
