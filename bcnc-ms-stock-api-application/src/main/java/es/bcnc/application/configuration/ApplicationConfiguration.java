package es.bcnc.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.bcnc.domain.api.searchprices.DomainSearchPricesServiceImpl;
import es.bcnc.domain.api.searchprices.IDomainSearchPricesService;
import es.bcnc.domain.spi.searchprices.IDomainSearchPricesRepositoryPort;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class ApplicationConfiguration {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI().addServersItem(new Server().url("/").description("Application Server URL"));
  }  
  
  @Bean
  public IDomainSearchPricesService getSearchPricesService(final IDomainSearchPricesRepositoryPort repo) {
	  return new DomainSearchPricesServiceImpl(repo);
  }
}

