package es.bgtiban.application.rest.socialmedia.accounts.create;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import es.bgtiban.domain.api.createAccount.DomainCreateAccountPort;
import es.bgtiban.malsin.rest.api.SocialMediaApi;
import es.bgtiban.malsin.rest.model.ApiAccountDto;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AppCreateAccountController implements SocialMediaApi {

    private AppCreateAccountMapper mapper;
    private DomainCreateAccountPort port;
    
    public AppCreateAccountController(AppCreateAccountMapper mapper, DomainCreateAccountPort port)  {
        this.mapper = mapper;
        this.port = port;
    }
    
    @Override
    public ResponseEntity<Void> createAccount(ApiAccountDto account) {
        port.createAccount(mapper.toDto(account));
        return ResponseEntity.ok().body(null);
    }

    
}
