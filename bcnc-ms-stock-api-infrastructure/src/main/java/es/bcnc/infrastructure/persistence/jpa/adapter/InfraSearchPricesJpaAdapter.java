package es.bcnc.infrastructure.persistence.jpa.adapter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import es.bcnc.domain.model.search_prices.DomainSearchPriceModel;
import es.bcnc.domain.spi.search_prices.IDomainSearchPricesRepositoryPort;
import es.bcnc.infrastructure.persistence.jpa.mapper.InfraSearchPricesMapper;
import es.bcnc.infrastructure.persistence.jpa.repository.InfraPricesRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class InfraSearchPricesJpaAdapter implements IDomainSearchPricesRepositoryPort {

	private InfraPricesRepository repo;
	private InfraSearchPricesMapper mapper;
	
	@Override
	public Optional<List<DomainSearchPriceModel>> searchPrices(LocalDateTime applicationDate, Long productId, Long brandID) {
		List<DomainSearchPriceModel> domainList = mapper.toModelList(repo.findAll());

		return 	Optional.ofNullable(domainList);
	}

}
