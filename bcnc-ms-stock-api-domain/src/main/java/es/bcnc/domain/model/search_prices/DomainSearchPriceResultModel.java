package es.bcnc.domain.model.search_prices;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainSearchPriceResultModel {

	private Long productId;
	private Long brandId;
	private Long rateId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private BigDecimal price;
}
