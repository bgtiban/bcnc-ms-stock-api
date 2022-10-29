package es.bcnc.application.rest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import es.bcnc.api.rest.api.ApiStockApi;
import es.bcnc.api.rest.model.ApiResponseSearchPriceDto;
import es.bcnc.domain.api.search_prices.IDomainSearchPricesService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AppSearchPricesController implements ApiStockApi {

	private IDomainSearchPricesService service;
	private IAppSearchPricesMapper mapper; 
	
	@Override
	public ResponseEntity<List<ApiResponseSearchPriceDto>> searchPrices(String applicationDate, String productId, String brandId) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime date = LocalDateTime.parse(applicationDate, formatter);
		List<ApiResponseSearchPriceDto> listDto =mapper.toDtoList(
				service.searchPrices(
						date, Long.parseLong(productId), Long.parseLong(brandId)));;
		return ResponseEntity.ok(listDto);
	}

}