
package org.bitducks.gamenav.ejb.session.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.bitducks.gamenav.dto.InscriptionFormDTO;
import org.bitducks.gamenav.dto.InscriptionJoueurDTO;
import org.bitducks.gamenav.dto.InscriptionUniversDTO;
import org.bitducks.gamenav.dto.UniversDTO;
import org.bitducks.gamenav.dtp.InscriptionFormDTP;
import org.bitducks.gamenav.dtp.InscriptionJoueurDTP;
import org.bitducks.gamenav.dtp.InscriptionUniversDTP;
import org.bitducks.gamenav.ejb.entity.Joueur;
import org.bitducks.gamenav.ejb.entity.JoueurUnivers;
import org.bitducks.gamenav.ejb.entity.Planete;
import org.bitducks.gamenav.ejb.entity.PlaneteRessource;
import org.bitducks.gamenav.ejb.entity.Ressource;
import org.bitducks.gamenav.ejb.entity.Univers;
import org.bitducks.gamenav.ejb.session.InscriptionService;
import org.bitducks.gamenav.ejb.session.base.GameNavBaseServiceBean;
import org.bitducks.gamenav.ejb.util.Util;

@Stateless
// @DeclareRoles({ GameNavRole.JOUEUR, GameNavRole.MODERATEUR,
// GameNavRole.ADMINISTRATEUR })
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class InscriptionServiceBean extends GameNavBaseServiceBean implements
		InscriptionService {

	// @PersistenceContext(unitName = "GameNavPU")
	// private EntityManager em;
	//
	// @Resource
	// private EJBContext ctx;
	//
	// @EJB
	// private PlaneteService planeteService;
	//
	// @EJB
	// private RessourceService ressourceService;
	//
	// @Override
	// @RolesAllowed({ GameNavRole.JOUEUR })
	// public void test() {
	//
	// System.out.println(this.ctx.getCallerPrincipal().getName());
	// System.out.println(this.ctx.isCallerInRole(GameNavRole.JOUEUR));
	// System.out.println(this.ctx.isCallerInRole(GameNavRole.MODERATEUR));
	// System.out.println(this.ctx.isCallerInRole(GameNavRole.ADMINISTRATEUR));
	// }

	@Override
	public InscriptionFormDTO getInscriptionFormDTO(InscriptionFormDTP dtp) {

		InscriptionFormDTO dto = new InscriptionFormDTO();
		dto.universList = new ArrayList<UniversDTO>();

		List<Univers> univers = this.universService.getAllUnivers();
		for (Univers u : univers) {
			dto.universList.add(new UniversDTO(u.getId(), u.getNom(),
					u.getDescription(), u.getDateCreation()));
		}

		return dto;
	}

	@Override
	public InscriptionJoueurDTO inscriptionJoueur(InscriptionJoueurDTP dtp) {

		InscriptionJoueurDTO dto = new InscriptionJoueurDTO();

		Joueur joueur = new Joueur();
		joueur.setEmail(dtp.email);
		joueur.setLogin(dtp.login);
		joueur.setPassword(Util.sha256(dtp.password));
		joueur.setInscriptionDate(new Date());

		joueur = this.em.merge(joueur);
		this.em.flush();

		dto.idJoueur = joueur.getId();

		InscriptionUniversDTP inscriptionJUDTP = new InscriptionUniversDTP();
		inscriptionJUDTP.idJoueur = joueur.getId();
		inscriptionJUDTP.idUnivers = dtp.idUnivers;
		inscriptionJUDTP.nomPlanete = dtp.nomPlanete;
		this.inscriptionJoueurUnivers(inscriptionJUDTP);

		return dto;
	}

	@Override
	public InscriptionUniversDTO inscriptionJoueurUnivers(
			InscriptionUniversDTP dtp) {

		InscriptionUniversDTO dto = new InscriptionUniversDTO();

		JoueurUnivers joueurUnivers = new JoueurUnivers();
		joueurUnivers.setJoueurId(dtp.idJoueur);
		joueurUnivers.setUniversId(dtp.idUnivers);

		joueurUnivers = this.em.merge(joueurUnivers);
		this.em.flush();

		Planete planete = this.getNextPlaneteMere(dtp.idUnivers);
		planete.setJoueurUnivers(joueurUnivers);
		planete.setNom(dtp.nomPlanete);
		planete = this.em.merge(planete);
		this.em.flush();

		List<Ressource> ressources = this.ressourceService.getAllRessources();
		for (Ressource ressource : ressources) {
			PlaneteRessource ressourcePlanete = new PlaneteRessource();
			ressourcePlanete.setDerniereMajRessource(new Date());
			ressourcePlanete.setRessource(ressource);
			ressourcePlanete.setPlanete(planete);
			ressourcePlanete.setNombre(ressource.getNombrePlaneteBase());
			this.em.persist(ressourcePlanete);
		}

		return dto;
	}

	private Planete getNextPlaneteMere(int universId) {

		Univers univers = this.em.find(Univers.class,
				Integer.valueOf(universId));

		for (int galaxie = univers.getLastGalaxie(); galaxie <= univers.getNbGalaxie(); ++galaxie) {
			for (int systemeSolaire = univers.getLastSystemeSolaire(); systemeSolaire <= univers.getNbSystemeSolaireGalaxie(); ++systemeSolaire) {
				List<Planete> planetes = this.planeteService.getPlanetesInGalaxieAndSystemeSolaire(
						galaxie, systemeSolaire);
				if (planetes.size() < univers.getNbEmplacementSystemeSolaire()
						/ univers.getNbEmplacementJoueur()) {

					Planete planete = new Planete();
					planete.setPlaneteMere(true);
					planete.setGalaxie(galaxie);
					planete.setSystemeSolaire(systemeSolaire);

					int emplacement;
					boolean emplacementChoosen = false;
					do {
						Random rand = new Random();
						emplacement = rand.nextInt();
						emplacement = emplacement < 0 ? emplacement * -1
								: emplacement;
						emplacement = (emplacement % univers.getNbEmplacementSystemeSolaire()) + 1;
						emplacementChoosen = true;
						for (Planete p : planetes) {
							if (p.getEmplacement() == emplacement) {
								emplacementChoosen = false;
								break;
							}
						}

					} while (!emplacementChoosen);

					planete.setEmplacement(emplacement);

					return planete;
				}
			}
		}

		throw new RuntimeException("The univers might be full.");
	}
}
