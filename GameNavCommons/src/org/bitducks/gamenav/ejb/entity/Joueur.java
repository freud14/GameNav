
package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the JOUEUR database table.
 * 
 */
@Entity
@Table(name = "JOUEUR")
public class Joueur implements Serializable {

	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int					id;

	@Column(name = "EMAIL")
	private String				email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INSCRIPTION_DATE")
	private Date				inscriptionDate;

	@Column(name = "LOGIN")
	private String				login;

	@Column(name = "PASSWORD")
	private String				password;

	// bi-directional many-to-one association to JoueurUnivers
	@OneToMany(mappedBy = "joueur")
	private List<JoueurUnivers>	joueurUnivers;

	public Joueur() {

	}

	public int getId() {

		return this.id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getEmail() {

		return this.email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public Date getInscriptionDate() {

		return this.inscriptionDate;
	}

	public void setInscriptionDate(Date inscriptionDate) {

		this.inscriptionDate = inscriptionDate;
	}

	public String getLogin() {

		return this.login;
	}

	public void setLogin(String login) {

		this.login = login;
	}

	public String getPassword() {

		return this.password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public List<JoueurUnivers> getJoueurUnivers() {

		return this.joueurUnivers;
	}

	public void setJoueurUnivers(List<JoueurUnivers> joueurUnivers) {

		this.joueurUnivers = joueurUnivers;
	}

	@Override
	public String toString() {

		return "Joueur [id=" + this.id + ", email=" + this.email
				+ ", inscriptionDate=" + this.inscriptionDate + ", login="
				+ this.login + ", password=" + this.password
				+ ", joueurUnivers=" + this.joueurUnivers + "]";
	}
}