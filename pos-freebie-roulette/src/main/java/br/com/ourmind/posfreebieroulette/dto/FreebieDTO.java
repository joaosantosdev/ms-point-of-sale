package br.com.ourmind.posfreebieroulette.dto;

import br.com.ourmind.posfreebieroulette.entities.Freebie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FreebieDTO {

	private Long id;

	private String description;

	private Double discount;

	public Freebie toEntity() {
		return new Freebie(this.id, this.description, this.discount);
	}

	public static FreebieDTO toDTO(Freebie freebie) {
		return new FreebieDTO(freebie.getId(), freebie.getDescription(), freebie.getDiscount());
	}

}
