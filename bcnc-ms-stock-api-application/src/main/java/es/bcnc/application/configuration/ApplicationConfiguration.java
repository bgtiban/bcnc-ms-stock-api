package es.bcnc.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.bcnc.domain.api.search_prices.DomainSearchPricesServiceImpl;
import es.bcnc.domain.api.search_prices.IDomainSearchPricesService;
import es.bcnc.domain.spi.search_prices.IDomainSearchPricesRepositoryPort;
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

