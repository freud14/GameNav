package org.bitducks.gamenav.ejb.session;

import javax.ejb.Remote;

import org.bitducks.gamenav.dto.InscriptionDTO;
import org.bitducks.gamenav.dtp.InscriptionDTP;

@Remote
public interface InscriptionService {
	public InscriptionDTO inscription(InscriptionDTP dtp);
	
	public void test();
}
