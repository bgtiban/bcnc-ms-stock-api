package es.bgtiban.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.bgtiban.domain.api.createAccount.DomainCreateAccountPort;
import es.bgtiban.domain.api.createAccount.DomainCreateAccountPortImpl;
import es.bgtiban.domain.spi.DomainCreateAccountRepositoryPort;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class ApplicationConfiguration {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI().addServersItem(new Server().url("/").description("Application Server URL"));
  }
  
  @Bean
  public DomainCreateAccountPort getCreateAccountPort(DomainCreateAccountRepositoryPort port) {
      return new DomainCreateAccountPortImpl(port);
  }
  
}

