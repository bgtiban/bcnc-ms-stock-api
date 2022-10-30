package es.bcnc.application.rest.searchPrices;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import es.bcnc.api.rest.api.ApiStockApi;
import es.bcnc.api.rest.model.ApiResponseSearchPriceDto;
import es.bcnc.domain.api.search_prices.IDomainSearchPricesService;
import es.bcnc.domain.cross.DomainCrossRegex;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AppSearchPricesController implements ApiStockApi {

	private IDomainSearchPricesService service;
	private IAppSearchPricesMapper mapper; 
	
	@Override
	public ResponseEntity<List<ApiResponseSearchPriceDto>> searchPrices(String applicationDate, String productId, String brandId) {
		LocalDateTime dateTime = LocalDateTime.parse(
				applicationDate, 
				DateTimeFormatter.ofPattern(DomainCrossRegex.BCNC_DATE_TIME_FORMAT.getRegex()));
		
		List<ApiResponseSearchPriceDto> listDto =mapper.toDtoList(
				service.searchPrices(dateTime, Long.parseLong(productId), Long.parseLong(brandId)));
		
		return ResponseEntity.ok(listDto);
	}

}