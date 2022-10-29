package es.bgtiban.application.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import es.bcnc.stock.api.rest.api.ApiStockApi;
import es.bcnc.stock.api.rest.model.ApiResponseSearchPriceDto;

@RestController
public class AppSearchPrices implements ApiStockApi {

	@Override
	public ResponseEntity<List<ApiResponseSearchPriceDto>> searchPrices(String applicationDate, String productId,
			String brandId) {
		return ApiStockApi.super.searchPrices(applicationDate, productId, brandId);
	}

}
