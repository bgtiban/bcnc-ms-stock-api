package es.bcnc.infrastructure.persistence.jpa.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Builder
@Entity
@Table(name="PRICES")
@Data
public class InfraPricesEntity {
	
	@Id
	Long id;
	
	@Column(name="BRAND_ID")
	Long brandId;
	
	@Column(name="START_DATE")
	LocalDateTime startDate;
	
	@Column(name="END_DATE")
	LocalDateTime endDate;
	
	@Column(name="PRICE_LIST")
	Long priceList;
	
	@Column(name="PRODUCT_ID")
	Long productId;

	Integer priority;
	BigDecimal price;
	String curr;
}
