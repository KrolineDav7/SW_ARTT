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
public class Suburb implements ISuburb {
 
    /**
     *int id 
     *String name 
     *bool enabled
     *Town town
     */
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
    @JoinColumn(name = "ID_Town", referencedColumnName = "id")
    private Town town; 

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
        final Suburb other = (Suburb) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    public Town getTown() {
        return town;
    }
    public void setTown(Town town){
        this.town=town;
    }

    @Override
    public String getName() {
          return name;
    }

    public void setName(String name) {
        this.name= name;
    }
    
    public void setEnable(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean getEnabled() {
        return enabled;
    }
    
}
