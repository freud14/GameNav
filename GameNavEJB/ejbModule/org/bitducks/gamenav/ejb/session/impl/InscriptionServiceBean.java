
package org.bitducks.gamenav.ejb.session.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
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
import org.bitducks.gamenav.ejb.entity.ConstructionTechnologie;
import org.bitducks.gamenav.ejb.entity.GrpeVaisseauJoueur;
import org.bitducks.gamenav.ejb.entity.Joueur;
import org.bitducks.gamenav.ejb.entity.JoueurDroit;
import org.bitducks.gamenav.ejb.entity.JoueurDroitPK;
import org.bitducks.gamenav.ejb.entity.JoueurUnivers;
import org.bitducks.gamenav.ejb.entity.Planete;
import org.bitducks.gamenav.ejb.entity.PlaneteBatiment;
import org.bitducks.gamenav.ejb.entity.PlaneteDefense;
import org.bitducks.gamenav.ejb.entity.PlaneteRessource;
import org.bitducks.gamenav.ejb.entity.PlaneteRessourcePK;
import org.bitducks.gamenav.ejb.entity.RechercheJoueur;
import org.bitducks.gamenav.ejb.entity.Ressource;
import org.bitducks.gamenav.ejb.entity.Trajet;
import org.bitducks.gamenav.ejb.entity.TrajetRessource;
import org.bitducks.gamenav.ejb.entity.Univers;
import org.bitducks.gamenav.ejb.role.GameNavRole;
import org.bitducks.gamenav.ejb.session.InscriptionService;
import org.bitducks.gamenav.ejb.session.base.GameNavBaseServiceBean;
import org.bitducks.gamenav.ejb.session.exception.InscriptionErrorCode;
import org.bitducks.gamenav.ejb.session.exception.InscriptionException;
import org.bitducks.gamenav.ejb.session.exception.base.GameNavError;
import org.bitducks.gamenav.ejb.util.Util;

@Stateless
@DeclareRoles({ GameNavRole.JOUEUR, GameNavRole.MODERATEUR,
		GameNavRole.ADMINISTRATEUR })
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class InscriptionServiceBean extends GameNavBaseServiceBean implements
		InscriptionService {

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
	public InscriptionJoueurDTO inscriptionJoueur(InscriptionJoueurDTP dtp)
			throws InscriptionException {

		InscriptionJoueurDTO dto = new InscriptionJoueurDTO();

		List<Joueur> joueurList = this.joueurService.getUserByLoginOrEmail(
				dtp.login, dtp.email);
		if (joueurList.size() != 0) {
			InscriptionException ex = new InscriptionException();
			for (Joueur j : joueurList) {
				if (j.getLogin().equals(dtp.login)) {
					ex.addError(new GameNavError(
							InscriptionErrorCode.LOGIN_UNIQUE));
				}

				if (j.getEmail().equals(dtp.email)) {
					ex.addError(new GameNavError(
							InscriptionErrorCode.EMAIL_UNIQUE));
				}
			}

			throw ex;
		}

		Joueur joueur = new Joueur();
		joueur.setEmail(dtp.email);
		joueur.setLogin(dtp.login);
		joueur.setPassword(Util.sha256(dtp.password));
		joueur.setInscriptionDate(new Date());

		joueur = this.em.merge(joueur);
		this.em.flush();

		JoueurDroit joueurDroit = new JoueurDroit();
		joueurDroit.setId(new JoueurDroitPK(joueur.getLogin(),
				GameNavRole.JOUEUR));
		this.em.persist(joueurDroit);

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
			InscriptionUniversDTP dtp) throws InscriptionException {

		InscriptionUniversDTO dto = new InscriptionUniversDTO();

		List<JoueurUnivers> joueurUniversList = this.joueurUniversService.getJoueurUnivers(
				dtp.idJoueur, dtp.idUnivers);
		if (joueurUniversList.size() != 0) {
			throw new InscriptionException(new GameNavError(
					InscriptionErrorCode.UNIVERS_UNIQUE));
		}

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
			ressourcePlanete.setId(new PlaneteRessourcePK(ressource.getId(),
					planete.getId()));
			ressourcePlanete.setDerniereMajRessource(new Date());
			ressourcePlanete.setNombre(ressource.getNombrePlaneteBase());
			this.em.persist(ressourcePlanete);
		}

		return dto;
	}

	private Planete getNextPlaneteMere(int universId)
			throws InscriptionException {

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

		throw new InscriptionException(new GameNavError(
				InscriptionErrorCode.UNIVERS_PLEIN));
	}

	@Override
	@RolesAllowed({ GameNavRole.ADMINISTRATEUR })
	public void removeInscription(int idJoueur) {

		Joueur joueurToRemove = this.em.find(Joueur.class,
				Integer.valueOf(idJoueur));

		List<JoueurDroit> joueurDroitToRemove = this.joueurDroitService.getJoueurDroitsByLogin(joueurToRemove.getLogin());

		List<JoueurUnivers> joueurUniversToRemove = joueurToRemove.getJoueurUnivers();

		List<Planete> planetesToRemove = new LinkedList<Planete>();
		List<RechercheJoueur> rechercheJoueurToRemove = new LinkedList<RechercheJoueur>();

		for (JoueurUnivers ju : joueurUniversToRemove) {
			planetesToRemove.addAll(ju.getPlanete());
			rechercheJoueurToRemove.addAll(ju.getRechercheJoueur());
		}

		List<ConstructionTechnologie> constructionTechnologieToRemove = new LinkedList<ConstructionTechnologie>();
		List<GrpeVaisseauJoueur> grpeVaisseauJoueurToRemove = new LinkedList<GrpeVaisseauJoueur>();
		List<PlaneteBatiment> planeteBatimentToRemove = new LinkedList<PlaneteBatiment>();
		List<PlaneteDefense> planeteDefenseToRemove = new LinkedList<PlaneteDefense>();
		List<PlaneteRessource> planeteRessourceToRemove = new LinkedList<PlaneteRessource>();
		List<Trajet> trajetToRemove = new LinkedList<Trajet>();

		for (Planete p : planetesToRemove) {
			constructionTechnologieToRemove.addAll(p.getConstructionTechnologie());
			grpeVaisseauJoueurToRemove.addAll(p.getGrpeVaisseauJoueur());
			planeteBatimentToRemove.addAll(p.getPlaneteBatiment());
			planeteDefenseToRemove.addAll(p.getPlaneteDefense());
			planeteRessourceToRemove.addAll(p.getPlaneteRessource());
			trajetToRemove.addAll(p.getTrajetDepart());
			trajetToRemove.addAll(p.getTrajetDestination());
		}

		List<TrajetRessource> trajetRessourceToRemove = new LinkedList<TrajetRessource>();
		for (Trajet t : trajetToRemove) {
			trajetRessourceToRemove.addAll(t.getTrajetRessource());
		}

		// Removal pass 1
		for (TrajetRessource i : trajetRessourceToRemove) {
			this.em.remove(i);
		}

		// Removal pass 2
		for (ConstructionTechnologie i : constructionTechnologieToRemove) {
			this.em.remove(i);
		}
		for (GrpeVaisseauJoueur i : grpeVaisseauJoueurToRemove) {
			this.em.remove(i);
		}
		for (PlaneteBatiment i : planeteBatimentToRemove) {
			this.em.remove(i);
		}
		for (PlaneteDefense i : planeteDefenseToRemove) {
			this.em.remove(i);
		}
		for (PlaneteRessource i : planeteRessourceToRemove) {
			this.em.remove(i);
		}
		for (Trajet i : trajetToRemove) {
			this.em.remove(i);
		}

		// Removal pass 3
		for (Planete i : planetesToRemove) {
			this.em.remove(i);
		}
		for (RechercheJoueur i : rechercheJoueurToRemove) {
			this.em.remove(i);
		}

		// Removal pass 4
		for (JoueurUnivers i : joueurUniversToRemove) {
			this.em.remove(i);
		}

		for (JoueurDroit i : joueurDroitToRemove) {
			this.em.remove(i);
		}

		this.em.remove(joueurToRemove);

	}
}
