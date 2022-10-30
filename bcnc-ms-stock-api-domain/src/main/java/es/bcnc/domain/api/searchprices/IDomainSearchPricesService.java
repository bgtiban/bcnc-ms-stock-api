package es.bcnc.domain.api.searchprices;

import java.time.LocalDateTime;
import java.util.List;

import es.bcnc.domain.model.searchprices.DomainSearchPriceResultModel;

public interface IDomainSearchPricesService {

	public List<DomainSearchPriceResultModel> searchPrices(LocalDateTime applicationDate, Long productId, Long brandID);
}
