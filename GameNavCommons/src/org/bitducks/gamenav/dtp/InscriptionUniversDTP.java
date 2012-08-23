
package org.bitducks.gamenav.dtp;

import org.bitducks.gamenav.dtp.base.BaseDTP;

public class InscriptionUniversDTP extends BaseDTP {

	public int		idJoueur;

	public int		idUnivers;

	public String	nomPlanete;

	@Override
	public String toString() {

		return "InscriptionUniversDTP [idJoueur=" + this.idJoueur
				+ ", idUnivers=" + this.idUnivers + ", nomPlanete="
				+ this.nomPlanete + "]";
	}

}
