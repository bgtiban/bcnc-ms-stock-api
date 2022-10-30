package es.bcnc.application.rest.searchprices;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.mapstruct.Mapper;

import es.bcnc.domain.cross.DomainCrossRegex;

@Mapper(componentModel = "spring")
public class AppLocalDateTimeToStringMapper {

	public String toString(LocalDateTime ldt) {
		return ldt.format(DateTimeFormatter.ofPattern(DomainCrossRegex.BCNC_DATE_TIME_FORMAT.getRegex()));
	}
	
}
