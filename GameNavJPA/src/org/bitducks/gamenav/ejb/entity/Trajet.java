package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TRAJET database table.
 * 
 */
@Entity
@Table(name="TRAJET")
public class Trajet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_DEPART")
	private Date dateDepart;

	@Column(name="TEMPS_TRAJET")
	private int tempsTrajet;

	//bi-directional many-to-many association to GrpeVaisseauJoueur
	@ManyToMany
	@JoinTable(
		name="TRAJET_VAISSEAU"
		, joinColumns={
			@JoinColumn(name="TRAJET_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="GRPE_VAISSEAU_JOUEUR_ID")
			}
		)
	private List<GrpeVaisseauJoueur> grpeVaisseauJoueur;

	//bi-directional many-to-one association to Planete
	@ManyToOne
	@JoinColumn(name="PLANETE_DEPART")
	private Planete depart;

	//bi-directional many-to-one association to Planete
	@ManyToOne
	@JoinColumn(name="PLANETE_DESTINATION")
	private Planete destination;

	//bi-directional many-to-one association to TypeTrajet
	@ManyToOne
	@JoinColumn(name="TYPE_TRAJET_ID")
	private TypeTrajet typeTrajet;

	//bi-directional many-to-one association to TrajetRessource
	@OneToMany(mappedBy="trajet")
	private List<TrajetRessource> trajetRessource;

	public Trajet() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDepart() {
		return this.dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public int getTempsTrajet() {
		return this.tempsTrajet;
	}

	public void setTempsTrajet(int tempsTrajet) {
		this.tempsTrajet = tempsTrajet;
	}

	public List<GrpeVaisseauJoueur> getGrpeVaisseauJoueur() {
		return this.grpeVaisseauJoueur;
	}

	public void setGrpeVaisseauJoueur(List<GrpeVaisseauJoueur> grpeVaisseauJoueur) {
		this.grpeVaisseauJoueur = grpeVaisseauJoueur;
	}

	public Planete getDepart() {
		return this.depart;
	}

	public void setDepart(Planete depart) {
		this.depart = depart;
	}

	public Planete getDestination() {
		return this.destination;
	}

	public void setDestination(Planete destination) {
		this.destination = destination;
	}

	public TypeTrajet getTypeTrajet() {
		return this.typeTrajet;
	}

	public void setTypeTrajet(TypeTrajet typeTrajet) {
		this.typeTrajet = typeTrajet;
	}

	public List<TrajetRessource> getTrajetRessource() {
		return this.trajetRessource;
	}

	public void setTrajetRessource(List<TrajetRessource> trajetRessource) {
		this.trajetRessource = trajetRessource;
	}

}