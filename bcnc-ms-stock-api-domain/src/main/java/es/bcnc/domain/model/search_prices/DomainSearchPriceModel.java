package es.bcnc.domain.model.search_prices;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainSearchPriceModel {

	private Long productId;
	private Long brandId;
	private Long rateId;
	private BigDecimal price;
}
