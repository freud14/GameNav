
package org.bitducks.gamenav.ejb.session.impl;

import java.util.Date;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.bitducks.gamenav.dto.InscriptionDTO;
import org.bitducks.gamenav.dtp.InscriptionDTP;
import org.bitducks.gamenav.ejb.entity.Joueur;
import org.bitducks.gamenav.ejb.entity.JoueurUnivers;
import org.bitducks.gamenav.ejb.entity.Univers;
import org.bitducks.gamenav.ejb.session.InscriptionService;
import org.bitducks.gamenav.ejb.util.Util;

@Stateless
@DeclareRoles({ "Admin-Group", "Regular-Group" })
public class InscriptionServiceBean implements InscriptionService {

	@PersistenceContext(unitName = "GameNavPU")
	private EntityManager	em;

	@Resource
	private EJBContext		ctx;
	
	@Override
	@RolesAllowed({ "Admin-Group" })
	public void test() {

		System.out.println(this.ctx.getCallerPrincipal().getName());
		System.out.println(this.ctx.isCallerInRole("Admin-Group"));
		System.out.println(this.ctx.isCallerInRole("Regular-Group"));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public InscriptionDTO inscription(InscriptionDTP dtp) {

		InscriptionDTO dto = new InscriptionDTO();

		Joueur joueur = new Joueur();
		joueur.setEmail(dtp.email);
		joueur.setLogin(dtp.login);
		joueur.setPassword(Util.sha256(dtp.password));
		joueur.setInscriptionDate(new Date());

		JoueurUnivers joueurUnivers = new JoueurUnivers();
		joueurUnivers.setJoueur(joueur);
		joueurUnivers.setUnivers(this.em.find(Univers.class,
				Integer.valueOf(dtp.idUnivers)));

		this.em.merge(joueurUnivers);

		return dto;
	}
}
