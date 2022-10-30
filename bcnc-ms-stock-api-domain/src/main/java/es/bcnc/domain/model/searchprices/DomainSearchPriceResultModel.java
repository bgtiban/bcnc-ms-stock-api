package es.bcnc.domain.model.searchprices;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DomainSearchPriceResultModel {

	private Long productId;
	private Long brandId;
	private Long rateId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private BigDecimal price;
}
