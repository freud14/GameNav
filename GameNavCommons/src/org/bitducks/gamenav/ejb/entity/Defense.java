
package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the DEFENSE database table.
 * 
 */
@Entity
@Table(name = "DEFENSE")
@DiscriminatorValue("DEFENSE")
public class Defense extends Technologie implements Serializable {

	private static final long		serialVersionUID	= 1L;

	@Column(name = "BOUCLIER")
	private int						bouclier;

	@Column(name = "COQUE")
	private int						coque;

	@Column(name = "FEU")
	private int						feu;

	// bi-directional many-to-one association to PlaneteDefense
	@OneToMany(mappedBy = "defense")
	private List<PlaneteDefense>	planeteDefense;

	public Defense() {

	}

	public int getBouclier() {

		return this.bouclier;
	}

	public void setBouclier(int bouclier) {

		this.bouclier = bouclier;
	}

	public int getCoque() {

		return this.coque;
	}

	public void setCoque(int coque) {

		this.coque = coque;
	}

	public int getFeu() {

		return this.feu;
	}

	public void setFeu(int feu) {

		this.feu = feu;
	}

	public List<PlaneteDefense> getPlaneteDefense() {

		return this.planeteDefense;
	}

	public void setPlaneteDefense(List<PlaneteDefense> planeteDefense) {

		this.planeteDefense = planeteDefense;
	}

}