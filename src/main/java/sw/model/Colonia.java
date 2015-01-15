/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sw.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Carolina
 * @author Jair
 */
@Entity
public class Colonia implements IColonia {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 60)
    @Column(unique = true)
    private String nombre;
    
    @NotNull
    private boolean disponible;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "MunicipioID", referencedColumnName = "id")
    private Municipio municipio; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 6;
        hash = 13 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
          if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Colonia other = (Colonia) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    public Municipio getMunicipio() {
        return municipio;
    }
    public void setMunicipio(Municipio municipio){
        this.municipio=municipio;
    }

    @Override
    public String getNombre() {
          return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre= nombre;
    }
    
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public boolean getDisponible() {
        return disponible;
    }
    
}
