package sw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import sw.model.Estado;
import sw.persistence.DaoEstado;

@Service
public class EstadoServices {
  
   @Autowired 
   private DaoEstado dao;
    
    public Estado obtenerNombre(String nombre){
       return dao.obtenerNombre(nombre); 
    }
    public List<Estado>obtenerTodos(){
        return dao.findAll();
    }
    public Estado obtnerUno (int id){
        return dao.findOne(id);
    }
  
    public int agregarEstado (Estado estado){
      
        Estado estado_=new Estado();
        estado_.setName(estado.getName());
        estado_.setEnabled(estado.isEnable());
        return dao.saveAndFlush(estado_)!=null? 0:-1;
    }
    public int actualizarEstado(Estado estado){
       
        Estado temp=dao.findOne(estado.getId());
        temp.setId(estado.getId());
        temp.setName(estado.getName());
        temp.setEnabled(estado.isEnable());
         return dao.saveAndFlush(temp)!=null? 0:-1;
    }
}
