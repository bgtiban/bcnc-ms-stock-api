package es.bcnc.infrastructure.persistence.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.bcnc.infrastructure.persistence.jpa.entity.InfraPricesEntity;

public interface InfraPricesRepository extends JpaRepository<InfraPricesEntity, Long>{

	@Query(nativeQuery = true,
			value="SELECT ID ,BRAND_ID ,START_DATE ,END_DATE ,PRICE_LIST ,PRODUCT_ID ,PRIORITY ,PRICE ,CURR \n"
					+ "FROM PRICES\n"
					+ "WHERE START_DATE <=  ?1 \n"
					+ "AND END_DATE >=  ?1 \n"
					+ "AND BRAND_ID = ?2\n"
					+ "AND PRICE_LIST = ?3")
	List<InfraPricesEntity> findPrices(String applicationDate, long brandId, long priceListId);

}
