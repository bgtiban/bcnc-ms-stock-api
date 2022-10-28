package es.bgtiban.domain.spi;

import java.util.Optional;

import es.bgtiban.domain.model.DomainCreateAccountModel;

public interface DomainCreateAccountRepositoryPort {

    public Optional<DomainCreateAccountModel> createAccounWithID(String name);

    public Optional<DomainCreateAccountModel> createAccountGeneratingID();
    
}
