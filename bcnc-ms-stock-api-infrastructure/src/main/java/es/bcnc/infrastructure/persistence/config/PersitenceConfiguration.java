package es.bcnc.infrastructure.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.bcnc.domain.spi.searchprices.IDomainSearchPricesRepositoryPort;
import es.bcnc.infrastructure.persistence.jpa.searchprices.adapter.InfraSearchPricesJpaAdapter;
import es.bcnc.infrastructure.persistence.jpa.searchprices.mapper.InfraSearchPricesMapper;
import es.bcnc.infrastructure.persistence.jpa.searchprices.repository.InfraPricesRepository;

@Configuration
public class PersitenceConfiguration {

    @Bean
    IDomainSearchPricesRepositoryPort getSearchPricesJpaAdapter(InfraPricesRepository repo, InfraSearchPricesMapper mapper) {
        return new InfraSearchPricesJpaAdapter(repo, mapper);
    }
}
