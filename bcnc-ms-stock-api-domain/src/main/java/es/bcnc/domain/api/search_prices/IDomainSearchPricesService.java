package es.bcnc.domain.api.search_prices;

import java.time.LocalDateTime;
import java.util.List;

import es.bcnc.domain.model.search_prices.DomainSearchPriceModel;

public interface IDomainSearchPricesService {

	public List<DomainSearchPriceModel> searchPrices(LocalDateTime applicationDate, Long productId, Long brandID);
}
