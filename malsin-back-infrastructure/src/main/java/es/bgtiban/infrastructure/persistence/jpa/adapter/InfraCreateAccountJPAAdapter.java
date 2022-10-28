package es.bgtiban.infrastructure.persistence.jpa.adapter;

import java.util.Optional;

import es.bgtiban.domain.model.DomainCreateAccountModel;
import es.bgtiban.domain.spi.DomainCreateAccountRepositoryPort;
import es.bgtiban.infrastructure.persistence.jpa.mapper.InfraAccountMapper;
import es.bgtiban.infrastructure.persistence.jpa.repository.InfraAccountRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InfraCreateAccountJPAAdapter implements DomainCreateAccountRepositoryPort {
   
    private InfraAccountRepository repo;
    
    private InfraAccountMapper mapper;
    
    public InfraCreateAccountJPAAdapter(InfraAccountRepository repo, InfraAccountMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }
    
    @Override
    public Optional<DomainCreateAccountModel> createAccounWithID(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<DomainCreateAccountModel> createAccountGeneratingID() {
        return Optional.empty();
    }

}
