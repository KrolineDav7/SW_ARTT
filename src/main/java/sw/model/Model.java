
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
public class Model implements Serializable {
  
  	 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 120)
    @Column(unique = true)
    private String name;
    
    @NotNull 
    @Size(min=1, max =300)
    @Column(unique=true)
    private String description;
    
    @NotNull
    private float latitude;
    
    @NotNull 
    private float longitude;
    
    @NotNull
    @Size(min = 1, max = 150)
    @Column(unique = true)
    private String file1;
    
    @NotNull
    @Size(min = 1, max = 150)
    @Column(unique = true)
    private String file2;
  
    @NotNull
    private boolean enabled;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_Suburb", referencedColumnName = "id")
    private Suburb suburb; 
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
     public String getName(){
      return name;
    }
  
     public void setName(String name) {
        this.name= name;
    }
    
    public boolean getEnable(){
     return enabled;
   }
    
   public void setEnable(boolean enable) {
        this.enabled = enable;
    }
  
    public String getDescription(){
     return description;
   }
   public void setDescription(String description){
     this.description=description;
   }

   public Suburb getSuburb() {
        return suburb;
    }
    public void setSuburb(Suburb suburb){
        this.suburb=suburb;
    }
    public float getLatitude(){
        return latitude;
    }
    public void setLatitude(float latitude){
        this.latitude=latitude;
    }
    public float getLongitude(){
        return longitude;
    }
    public void setLongitude(float longitude){
        this.longitude=longitude;
    }
    public String getFile1Path(){
        return file1;
    }
    public String getFile2Path(){
        return file2;
    }
    public void setFile1Path(String file1){
        this.file1=file1;
    }
    public void setFile2Path(String file2){
        this.file2=file2;
    }
    @Override
    public int hashCode() {
        int hash = 17;
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
        final Model other = (Model) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
}
