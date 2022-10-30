package es.bcnc;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.bcnc.api.rest.model.ApiResponseSearchPriceDto;
import es.bcnc.application.rest.searchprices.AppSearchPricesController;

@SpringBootTest
class SpringBootApplicationTests {


	@Autowired
	private AppSearchPricesController controller;
	
	@Test
	void tes1() {
		ApiResponseSearchPriceDto r1 = new ApiResponseSearchPriceDto();
		r1.setProductId("35455");
		r1.setBrandId("1");
		r1.setStartDate("2020-06-14-00.00.00");
		r1.setPrice(new BigDecimal("35.50"));
		r1.setRateId("1");
		r1.setEndDate("2020-12-31-23.59.59");

		List<ApiResponseSearchPriceDto> expected = Arrays.asList(r1);
		
		List<ApiResponseSearchPriceDto> actual = controller.searchPrices("2020-06-14-10.00.00", "35455", "1").getBody();
		
		assertThat(actual.toString()).isEqualTo(expected.toString());
		
	}
	
	@Test
	void tes2() {
		ApiResponseSearchPriceDto r1 = new ApiResponseSearchPriceDto();
		r1.setProductId("35455");
		r1.setBrandId("1");
		r1.setStartDate("2020-06-14-00.00.00");
		r1.setPrice(new BigDecimal("35.50"));
		r1.setRateId("1");
		r1.setEndDate("2020-12-31-23.59.59");
		
		ApiResponseSearchPriceDto r2 = new ApiResponseSearchPriceDto();
		r2.setProductId("35455");
		r2.setBrandId("1");
		r2.setStartDate("2020-06-14-15.00.00");
		r2.setPrice(new BigDecimal("25.45"));
		r2.setRateId("2");
		r2.setEndDate("2020-06-14-18.30.00");

		List<ApiResponseSearchPriceDto> expected = Arrays.asList(r1,r2);
		
		List<ApiResponseSearchPriceDto> actual = controller.searchPrices("2020-06-14-16.00.00", "35455", "1").getBody();
		
		assertThat(actual.toString()).isEqualTo(expected.toString());
		
	}
	
	@Test
	void tes3() {
		ApiResponseSearchPriceDto r1 = new ApiResponseSearchPriceDto();
		r1.setProductId("35455");
		r1.setBrandId("1");
		r1.setStartDate("2020-06-14-00.00.00");
		r1.setPrice(new BigDecimal("35.50"));
		r1.setRateId("1");
		r1.setEndDate("2020-12-31-23.59.59");

		List<ApiResponseSearchPriceDto> expected = Arrays.asList(r1);
		
		List<ApiResponseSearchPriceDto> actual = controller.searchPrices("2020-06-14-21.00.00", "35455", "1").getBody();
		
		assertThat(actual.toString()).isEqualTo(expected.toString());
		
	}
	
	@Test
	void tes4() {
		ApiResponseSearchPriceDto r1 = new ApiResponseSearchPriceDto();
		r1.setProductId("35455");
		r1.setBrandId("1");
		r1.setStartDate("2020-06-14-00.00.00");
		r1.setPrice(new BigDecimal("35.50"));
		r1.setRateId("1");
		r1.setEndDate("2020-12-31-23.59.59");
		
		ApiResponseSearchPriceDto r2 = new ApiResponseSearchPriceDto();
		r2.setProductId("35455");
		r2.setBrandId("1");
		r2.setStartDate("2020-06-15-00.00.00");
		r2.setPrice(new BigDecimal("30.50"));
		r2.setRateId("3");
		r2.setEndDate("2020-06-15-11.00.00");

		List<ApiResponseSearchPriceDto> expected = Arrays.asList(r1, r2);
		
		List<ApiResponseSearchPriceDto> actual = controller.searchPrices("2020-06-15-10.00.00", "35455", "1").getBody();
		
		assertThat(actual.toString()).isEqualTo(expected.toString());
		
	}
	
	@Test
	void tes5() {
		ApiResponseSearchPriceDto r1 = new ApiResponseSearchPriceDto();
		r1.setProductId("35455");
		r1.setBrandId("1");
		r1.setStartDate("2020-06-14-00.00.00");
		r1.setPrice(new BigDecimal("35.50"));
		r1.setRateId("1");
		r1.setEndDate("2020-12-31-23.59.59");
		
		ApiResponseSearchPriceDto r2 = new ApiResponseSearchPriceDto();
		r2.setProductId("35455");
		r2.setBrandId("1");
		r2.setStartDate("2020-06-15-16.00.00");
		r2.setPrice(new BigDecimal("38.95"));
		r2.setRateId("4");
		r2.setEndDate("2020-12-31-23.59.59");

		List<ApiResponseSearchPriceDto> expected = Arrays.asList(r1, r2);
		
		List<ApiResponseSearchPriceDto> actual = controller.searchPrices("2020-06-16-21.00.00", "35455", "1").getBody();
		
		assertThat(actual.toString()).isEqualTo(expected.toString());
		
	}

}
