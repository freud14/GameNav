
package org.bitducks.gamenav.entityutil;

import java.util.List;

import org.bitducks.gamenav.ejb.entity.Planete;

public interface PlaneteService {

	List<Planete> getPlanetesInGalaxieAndSystemeSolaire(int galaxie,
			int systemeSolaire);
}
