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
public class Estado implements IEstado {
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
    @JoinColumn(name = "PaisID", referencedColumnName = "id")
    private Pais pais; 
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + this.id;
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
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    public Pais getPais() {
        return pais;
    }
    public void setPais(Pais pais){
        this.pais=pais;
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
