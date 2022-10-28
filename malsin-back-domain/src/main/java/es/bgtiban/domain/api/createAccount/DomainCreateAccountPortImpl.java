package es.bgtiban.domain.api.createAccount;

import java.util.Optional;

import es.bgtiban.domain.model.DomainCreateAccountModel;
import es.bgtiban.domain.spi.DomainCreateAccountRepositoryPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DomainCreateAccountPortImpl implements DomainCreateAccountPort {

    DomainCreateAccountRepositoryPort repository;
    
    public DomainCreateAccountPortImpl(DomainCreateAccountRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public String createAccount(DomainCreateAccountModel model) {
        Optional<DomainCreateAccountModel> accountCreated = Optional.empty();

        if (model != null && (model.getId() == null || model.getId().trim().isEmpty())) {
            accountCreated = repository.createAccountGeneratingID();
        } else {
            accountCreated = repository.createAccounWithID(model.getId());
        }
        

        return accountCreated.isEmpty() ? "" : accountCreated.get().getId();
    }

}
