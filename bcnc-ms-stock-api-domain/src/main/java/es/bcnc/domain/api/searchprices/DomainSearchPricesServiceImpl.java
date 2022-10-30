package es.bcnc.domain.api.searchprices;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import es.bcnc.domain.model.searchprices.DomainSearchPriceResultModel;
import es.bcnc.domain.spi.searchprices.IDomainSearchPricesRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class DomainSearchPricesServiceImpl implements IDomainSearchPricesService {

	private IDomainSearchPricesRepositoryPort repo;
	
	
	@Override
	public List<DomainSearchPriceResultModel> searchPrices(LocalDateTime applicationDate, Long productId, Long brandID) {
		return repo.searchPrices(applicationDate, productId, brandID).orElse(Collections.emptyList());
	}
	

}
