
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sw.model;


import java.io.Serializable;
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
public class Modelo implements Serializable {
  
  	 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 120)
    @Column(unique = true)
    private String nombre;
    
    @NotNull 
    @Size(min=1, max =300)
    @Column(unique=true)
    private String descripcion;
  
  	 @NotNull
    private boolean disponible;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "ColoniaID", referencedColumnName = "id")
    private Colonia colonia; 
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
  	 public String getNombre(){
      return nombre;
    }
  
  	 public void setNombre(String nombre) {
        this.nombre= nombre;
    }
    
  	public boolean getDisponible(){
     return disponible;
   }
    
   public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
  
  	public String getDescripcion(){
     return descripcion;
   }
   public void setDescripcion(String descripcion){
     this.descripcion=descripcion;
   }

   public Colonia getColonia() {
        return colonia;
    }
    public void setColonia(Colonia colonia){
        this.colonia=colonia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
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
        final Modelo other = (Modelo) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
}
