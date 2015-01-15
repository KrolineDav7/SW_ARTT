package sw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import sw.model.Modelo;
import sw.persistence.DaoModelo;

@Service
public class ModeloServices {

  @Autowired
  private DaoModelo dao;
  
   public  Modelo obtenerXNombre(String nombre){
       return dao.obtenerXNombre(nombre); 
    }
    public List<Modelo>obtenerTodos(){
        return dao.findAll();
    }
    public Modelo obtenerUno (int id){
        return dao.findOne(id);
    }
    public int agregarModelo (Modelo modelo){
      
        Modelo modelo_=new Modelo();
        modelo_.setNombre(modelo.getNombre());
        modelo_.setColonia(modelo.getColonia());
        modelo_.setDisponible(modelo.getDisponible());
        modelo_.setDescripcion(modelo.getDescripcion());
        return dao.saveAndFlush(modelo_)!=null? 0:-1;
    }
    public int actualizarModelo(	Modelo modelo){
       
        Modelo temp=dao.findOne(modelo.getId());
        temp.setId(modelo.getId());
        temp.setNombre(modelo.getNombre());
        temp.setColonia(modelo.getColonia());
        temp.setDisponible(modelo.getDisponible());
        temp.setDescripcion(modelo.getDescripcion());
         return dao.saveAndFlush(temp)!=null? 0:-1;
    }
    public int eliminarModelo (Modelo modelo){
      Modelo temp=dao.findOne(modelo.getId());
      temp.setDisponible(false);
      return dao.saveAndFlush(temp)!=null? 0:-1;
    }
}
