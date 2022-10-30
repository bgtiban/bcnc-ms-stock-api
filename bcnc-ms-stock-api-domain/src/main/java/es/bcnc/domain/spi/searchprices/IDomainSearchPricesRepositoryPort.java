package es.bcnc.domain.spi.searchprices;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import es.bcnc.domain.model.searchprices.DomainSearchPriceResultModel;

public interface IDomainSearchPricesRepositoryPort {

	Optional<List<DomainSearchPriceResultModel>> searchPrices(LocalDateTime applicationDate, Long productId, Long brandID);
}
