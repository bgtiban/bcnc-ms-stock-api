package es.bcnc.application.rest;

import java.util.List;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;

import es.bcnc.api.rest.model.ApiResponseSearchPriceDto;
import es.bcnc.domain.model.search_prices.DomainSearchPriceModel;



@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, injectionStrategy = InjectionStrategy.CONSTRUCTOR,
componentModel = "spring")
public interface IAppSearchPricesMapper {

	public ApiResponseSearchPriceDto toDto(DomainSearchPriceModel model);
	
	public List<ApiResponseSearchPriceDto> toDtoList(List<DomainSearchPriceModel> models);
}
