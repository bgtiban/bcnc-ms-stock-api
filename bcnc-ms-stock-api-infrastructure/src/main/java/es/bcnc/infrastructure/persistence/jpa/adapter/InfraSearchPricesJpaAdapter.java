package es.bcnc.infrastructure.persistence.jpa.adapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import es.bcnc.domain.model.searchprices.DomainSearchPriceResultModel;
import es.bcnc.domain.spi.searchprices.IDomainSearchPricesRepositoryPort;
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
	public Optional<List<DomainSearchPriceResultModel>> searchPrices(LocalDateTime applicationDate, Long productId, Long brandID) {
		List<DomainSearchPriceResultModel> domainList = mapper.toModelList(
				repo.findPriceByPriority(applicationDate.format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")),
						productId, 
						brandID));

		return 	Optional.ofNullable(domainList);
	}

}
