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
 */
@Entity
public class Municipio implements IMunicipio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
   @NotNull
    @Size(min = 1, max = 60)
    @Column(unique = true)
    private String name;
    
    @NotNull
    private boolean enabled;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "EstadoID", referencedColumnName = "id")
    private Estado estado; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.id;
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
        final Municipio other = (Municipio) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
     public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado){
        this.estado=estado;
    }

    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name= name;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isEnable() {
       return enabled;
    }
    
}
