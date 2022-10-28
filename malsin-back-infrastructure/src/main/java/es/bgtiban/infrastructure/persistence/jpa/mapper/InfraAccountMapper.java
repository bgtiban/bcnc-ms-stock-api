package es.bgtiban.infrastructure.persistence.jpa.mapper;

import org.mapstruct.Mapper;

import es.bgtiban.domain.model.DomainCreateAccountModel;
import es.bgtiban.infrastructure.persistence.jpa.entity.InfraAccountEntity;

@Mapper
public interface InfraAccountMapper {

    public DomainCreateAccountModel toModel(InfraAccountEntity account);

}
