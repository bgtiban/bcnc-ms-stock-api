package es.bgtiban.infrastructure.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.bgtiban.domain.spi.DomainCreateAccountRepositoryPort;
import es.bgtiban.infrastructure.persistence.jpa.adapter.InfraCreateAccountJPAAdapter;
import es.bgtiban.infrastructure.persistence.jpa.mapper.InfraAccountMapper;
import es.bgtiban.infrastructure.persistence.jpa.repository.InfraAccountRepository;

@Configuration
public class PersitenceConfiguration {

    @Bean
    public DomainCreateAccountRepositoryPort getCreateAccountJPAAdapter(InfraAccountMapper mapper, InfraAccountRepository repository) {
        return new InfraCreateAccountJPAAdapter(repository, mapper);
    }
    
}
