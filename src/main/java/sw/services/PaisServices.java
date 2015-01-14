/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sw.model.Pais;
import sw.persistence.DaoPais;

import java.util.List;
/**
 *
 * @author Carolina
 */
@Service
public class PaisServices {
   @Autowired 
   private DaoPais dao;
    
    public Pais getByName(String name){
       return dao.getByName(name); 
    }
    public List<Pais>getAll(){
        return dao.findAll();
    }
    public Pais getOne(int id){
        return dao.findOne(id);
    }
  
    public int addPais(Pais pais){
        Pais pais_=new Pais();
        pais_.setName(pais.getName());
        pais_.setEnabled(pais.isEnable());
        return dao.saveAndFlush(pais_)!=null? 0:-1;
       
    }
    public int updatePais(Pais pais){
       
        Pais temp=dao.findOne(pais.getId());
        temp.setId(pais.getId());
        temp.setName(pais.getName());
        temp.setEnabled(pais.isEnable());
         return dao.saveAndFlush(temp)!=null? 0:-1;
    }
 
}
