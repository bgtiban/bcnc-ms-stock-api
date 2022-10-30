package es.bcnc.application.rest.searchprices;

import java.util.List;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;

import es.bcnc.api.rest.model.ApiResponseSearchPriceDto;
import es.bcnc.domain.model.searchprices.DomainSearchPriceResultModel;



@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, injectionStrategy = InjectionStrategy.CONSTRUCTOR,
componentModel = "spring", uses = {AppLocalDateTimeToStringMapper.class})
public interface IAppSearchPricesMapper {

	public ApiResponseSearchPriceDto toDto(DomainSearchPriceResultModel model);
	
	public List<ApiResponseSearchPriceDto> toDtoList(List<DomainSearchPriceResultModel> models);
}
