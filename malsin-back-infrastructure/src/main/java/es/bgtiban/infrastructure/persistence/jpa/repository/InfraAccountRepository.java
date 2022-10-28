package es.bgtiban.infrastructure.persistence.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.bgtiban.infrastructure.persistence.jpa.entity.InfraAccountEntity;

public interface InfraAccountRepository extends JpaRepository<InfraAccountEntity, String> {
    
    
    
}
