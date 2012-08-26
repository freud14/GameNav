
package org.bitducks.gamenav.ejb.session;

import javax.ejb.Remote;

import org.bitducks.gamenav.dto.InscriptionFormDTO;
import org.bitducks.gamenav.dto.InscriptionJoueurDTO;
import org.bitducks.gamenav.dto.InscriptionUniversDTO;
import org.bitducks.gamenav.dtp.InscriptionFormDTP;
import org.bitducks.gamenav.dtp.InscriptionJoueurDTP;
import org.bitducks.gamenav.dtp.InscriptionUniversDTP;
import org.bitducks.gamenav.ejb.session.exception.InscriptionException;

@Remote
public interface InscriptionService {

	InscriptionFormDTO getInscriptionFormDTO(InscriptionFormDTP dtp);

	InscriptionJoueurDTO inscriptionJoueur(InscriptionJoueurDTP dtp)
			throws InscriptionException;

	InscriptionUniversDTO inscriptionJoueurUnivers(InscriptionUniversDTP dtp)
			throws InscriptionException;

	void removeInscription(int idJoueur);
}
