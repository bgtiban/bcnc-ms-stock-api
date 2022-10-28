package es.bgtiban.domain.api.createAccount;

import es.bgtiban.domain.model.DomainCreateAccountModel;

public interface DomainCreateAccountPort {
    
    public String createAccount(DomainCreateAccountModel account);
}
