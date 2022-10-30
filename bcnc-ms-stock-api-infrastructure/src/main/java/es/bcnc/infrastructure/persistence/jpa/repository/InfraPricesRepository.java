package es.bcnc.infrastructure.persistence.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.bcnc.infrastructure.persistence.jpa.entity.InfraPricesEntity;

public interface InfraPricesRepository extends JpaRepository<InfraPricesEntity, Long>{

	@Query(nativeQuery = true,
			value="SELECT ID ,BRAND_ID ,START_DATE ,END_DATE ,PRICE_LIST ,PRODUCT_ID ,PRIORITY ,PRICE ,CURR "
					+ "FROM PRICES "
					+ "WHERE START_DATE >= ?1 "
					+ "AND END_DATE <= ?1 "
					+ "AND BRAND_ID = ?2 "
					+ "AND PRICE_LIST = ?3 ")
	List<InfraPricesEntity> findPrices(String applicationDate, long brandId, long priceListId);

}
