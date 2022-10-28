package es.bgtiban.infrastructure.persistence.jpa.entity;
// Generated 6 sept 2022 12:48:20 by Hibernate Tools 5.2.13.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Peticiones generated by hbm2java
 */
@Entity
@Table(name = "peticiones")
public class Peticiones implements java.io.Serializable {

    private int id;
    private Ubicaciones ubicaciones;
    private String descripcion;
    private Date fechaPeticion;
    private String multimedia;
    private int categoria;
    private Set peticionesRelCuentases = new HashSet(0);
    private Set historicoPeticionesRelRedeses = new HashSet(0);
    private Set historicoPeticioneses = new HashSet(0);

    public Peticiones() {
    }

    public Peticiones(int id, Ubicaciones ubicaciones, Date fechaPeticion, String multimedia, int categoria) {
        this.id = id;
        this.ubicaciones = ubicaciones;
        this.fechaPeticion = fechaPeticion;
        this.multimedia = multimedia;
        this.categoria = categoria;
    }

    public Peticiones(int id, Ubicaciones ubicaciones, String descripcion, Date fechaPeticion, String multimedia,
            int categoria, Set peticionesRelCuentases, Set historicoPeticionesRelRedeses, Set historicoPeticioneses) {
        this.id = id;
        this.ubicaciones = ubicaciones;
        this.descripcion = descripcion;
        this.fechaPeticion = fechaPeticion;
        this.multimedia = multimedia;
        this.categoria = categoria;
        this.peticionesRelCuentases = peticionesRelCuentases;
        this.historicoPeticionesRelRedeses = historicoPeticionesRelRedeses;
        this.historicoPeticioneses = historicoPeticioneses;
    }

    @Id

    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ubicacion", nullable = false)
    public Ubicaciones getUbicaciones() {
        return this.ubicaciones;
    }

    public void setUbicaciones(Ubicaciones ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    @Column(name = "descripcion", length = 280)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_peticion", nullable = false, length = 29)
    public Date getFechaPeticion() {
        return this.fechaPeticion;
    }

    public void setFechaPeticion(Date fechaPeticion) {
        this.fechaPeticion = fechaPeticion;
    }

    @Column(name = "multimedia", nullable = false, length = 100)
    public String getMultimedia() {
        return this.multimedia;
    }

    public void setMultimedia(String multimedia) {
        this.multimedia = multimedia;
    }

    @Column(name = "categoria", nullable = false)
    public int getCategoria() {
        return this.categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "peticiones")
    public Set getPeticionesRelCuentases() {
        return this.peticionesRelCuentases;
    }

    public void setPeticionesRelCuentases(Set peticionesRelCuentases) {
        this.peticionesRelCuentases = peticionesRelCuentases;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "peticiones")
    public Set getHistoricoPeticionesRelRedeses() {
        return this.historicoPeticionesRelRedeses;
    }

    public void setHistoricoPeticionesRelRedeses(Set historicoPeticionesRelRedeses) {
        this.historicoPeticionesRelRedeses = historicoPeticionesRelRedeses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "peticiones")
    public Set getHistoricoPeticioneses() {
        return this.historicoPeticioneses;
    }

    public void setHistoricoPeticioneses(Set historicoPeticioneses) {
        this.historicoPeticioneses = historicoPeticioneses;
    }

}
