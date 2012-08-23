
package org.bitducks.gamenav.dtp;

import org.bitducks.gamenav.dtp.base.BaseDTP;

public class InscriptionJoueurDTP extends BaseDTP {

	public String	email;

	public String	login;

	public String	password;

	public int		idUnivers;

	public String	nomPlanete;

	@Override
	public String toString() {

		return "InscriptionJoueurDTP [email=" + this.email + ", login="
				+ this.login + ", password=" + this.password + ", idUnivers="
				+ this.idUnivers + ", nomPlanete=" + this.nomPlanete + "]";
	}

}
