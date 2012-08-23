
package org.bitducks.gamenav.dto;

import java.util.List;

import org.bitducks.gamenav.dto.base.BaseDTO;

public class InscriptionFormDTO extends BaseDTO {

	public List<UniversDTO>	universList;

	@Override
	public String toString() {

		return "InscriptionFormDTO [universList=" + this.universList + "]";
	}

}
