package es.bgtiban.infrastructure.persistence.jpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity(name = "cuentas")
public class InfraAccountEntity {
    
    @Id
    @Column(name = "id")
    String id;
    
    @Column(name = "fecha_alta")
    LocalDateTime creationDate;
}
