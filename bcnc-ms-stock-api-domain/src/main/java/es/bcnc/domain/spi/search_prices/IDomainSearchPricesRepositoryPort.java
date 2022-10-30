package es.bcnc.domain.spi.search_prices;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import es.bcnc.domain.model.search_prices.DomainSearchPriceResultModel;

public interface IDomainSearchPricesRepositoryPort {

	Optional<List<DomainSearchPriceResultModel>> searchPrices(LocalDateTime applicationDate, Long productId, Long brandID);
}
