/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sw.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sw.model.Estado;
import sw.model.Municipio;
import sw.persistence.DaoMunicipio;

/**
 *
 * @author Carolina
 */
@Service 
public class MunicipioServices {
    @Autowired
    private DaoMunicipio dao;
    
      public Municipio obtenerXNombre(String nombre){
       return dao.obtenerXNombre(nombre); 
    }
    public List<Municipio>obtenerTodos(){
        return dao.findAll();
    }
    public Municipio obtnerUno (int id){
        return dao.findOne(id);
    }
  
    public int agregarMuncipio (Municipio municipio){
      
        Municipio municipio_=new Municipio();
        municipio_.setNombre(municipio.getNombre());
        municipio_.setDisponible(municipio.getDisponible());
        municipio_.setEstado(municipio.getEstado());
        return dao.saveAndFlush(municipio_)!=null? 0:-1;
    }
    public int actualizarMunicipio(Municipio municipio){
       
        Municipio temp=dao.findOne(municipio.getId());
        temp.setId(municipio.getId());
        temp.setNombre(municipio.getNombre());
        temp.setEstado(municipio.getEstado());
        temp.setDisponible(municipio.getDisponible());
         return dao.saveAndFlush(temp)!=null? 0:-1;
    }
}
