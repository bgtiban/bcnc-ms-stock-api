package es.bcnc.domain.api.search_prices;

import java.time.LocalDateTime;
import java.util.List;

import es.bcnc.domain.model.search_prices.DomainSearchPriceResultModel;

public interface IDomainSearchPricesService {

	public List<DomainSearchPriceResultModel> searchPrices(LocalDateTime applicationDate, Long productId, Long brandID);
}
