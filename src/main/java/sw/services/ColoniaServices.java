package sw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import sw.model.Colonia;
import sw.persistence.DaoColonia;

@Service
public class ColoniaServices {

  @Autowired 
  private DaoColonia dao;
  
   public Colonia obtenerXNombre(String nombre){
       return dao.obtenerXNombre(nombre); 
    }
    public List<Colonia>obtenerTodos(){
        return dao.findAll();
    }
    public Colonia obtnerUno (int id){
        return dao.findOne(id);
    }
  
    public int agregarColonia (Colonia colonia){
      
        Colonia colonia_=new Colonia();
        colonia_.setNombre(colonia.getNombre());
        colonia_.setMunicipio(colonia.getMunicipio());
        colonia_.setDisponible(colonia.getDisponible());
        return dao.saveAndFlush(colonia_)!=null? 0:-1;
    }
    public int actualizarColonia(Colonia colonia){
       
        Colonia temp=dao.findOne(colonia.getId());
        temp.setId(colonia.getId());
        temp.setNombre(colonia.getNombre());
        temp.setMunicipio(colonia.getMunicipio());
        temp.setDisponible(colonia.getDisponible());
         return dao.saveAndFlush(temp)!=null? 0:-1;
    }
}
