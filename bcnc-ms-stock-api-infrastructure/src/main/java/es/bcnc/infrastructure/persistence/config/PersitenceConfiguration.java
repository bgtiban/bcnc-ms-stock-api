package es.bcnc.infrastructure.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.bcnc.domain.spi.search_prices.IDomainSearchPricesRepositoryPort;
import es.bcnc.infrastructure.persistence.jpa.adapter.InfraSearchPricesJpaAdapter;
import es.bcnc.infrastructure.persistence.jpa.mapper.InfraSearchPricesMapper;
import es.bcnc.infrastructure.persistence.jpa.repository.InfraPricesRepository;

@Configuration
public class PersitenceConfiguration {

    @Bean
    public IDomainSearchPricesRepositoryPort getSearchPricesJpaAdapter(InfraPricesRepository repo, InfraSearchPricesMapper mapper) {
    	return new InfraSearchPricesJpaAdapter(repo, mapper);
    }
}
