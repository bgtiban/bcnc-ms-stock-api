package es.bcnc.infrastructure.persistence.jpa.mapper;

import java.util.List;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;

import es.bcnc.domain.model.searchprices.DomainSearchPriceResultModel;
import es.bcnc.infrastructure.persistence.jpa.entity.InfraPricesEntity;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, injectionStrategy = InjectionStrategy.CONSTRUCTOR,
componentModel = "spring")
public interface InfraSearchPricesMapper {
	
	@Mapping(target = "rateId", source = "priceList")
	public DomainSearchPriceResultModel toModel(InfraPricesEntity entity);
	
	
	public List<DomainSearchPriceResultModel> toModelList(List<InfraPricesEntity> entities);
}
