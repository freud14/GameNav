
package org.bitducks.gamenav.entityutil;

import java.util.List;

import org.bitducks.gamenav.ejb.entity.JoueurUnivers;

public interface JoueurUniversService {

	List<JoueurUnivers> getJoueurUnivers(int joueurId, int universId);
}
