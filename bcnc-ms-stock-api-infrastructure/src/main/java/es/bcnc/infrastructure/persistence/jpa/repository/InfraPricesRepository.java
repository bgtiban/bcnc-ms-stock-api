package es.bcnc.infrastructure.persistence.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.bcnc.infrastructure.persistence.jpa.entity.InfraPricesEntity;

public interface InfraPricesRepository extends JpaRepository<InfraPricesEntity, Long>{

}
