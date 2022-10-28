package es.bgtiban.application.rest.socialmedia.accounts.create;

import org.mapstruct.Mapper;

import es.bgtiban.domain.model.DomainCreateAccountModel;
import es.bgtiban.malsin.rest.model.ApiAccountDto;

@Mapper
public interface AppCreateAccountMapper {

    DomainCreateAccountModel toDto(ApiAccountDto account);

}
