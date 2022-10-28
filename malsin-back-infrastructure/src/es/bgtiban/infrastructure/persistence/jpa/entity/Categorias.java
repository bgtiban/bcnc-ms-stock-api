package es.bgtiban.infrastructure.persistence.jpa.entity;
// Generated 6 sept 2022 12:48:20 by Hibernate Tools 5.2.13.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Categorias generated by hbm2java
 */
@Entity
@Table(name = "categorias")
public class Categorias implements java.io.Serializable {

    private int id;
    private String descripcion;

    public Categorias() {
    }

    public Categorias(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    @Id

    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "descripcion", nullable = false, length = 200)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
