/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sw.model.Country;
import sw.persistence.DaoCountry;

import java.util.List;
import sw.model.State;
import sw.persistence.DaoState;
/**
 *
 * @author Carolina
 */
@Service
public class CountryServices {
   @Autowired 
   private DaoCountry dao;
   private DaoState daos;
    
    public List<Country>getAll(){
        return dao.findAll();
    }
    public Country getOne(int id){
        return dao.findOne(id);
    }
  
    public int addPais(Country country){
        Country country_=new Country();
        country_.setName(country.getName());
        country_.setEnable(country.getEnable());
        return dao.saveAndFlush(country_)!=null? 0:-1;
       
    }
    public int updateCountry(Country country){
       
        Country temp=dao.findOne(country.getId());
        temp.setId(country.getId());
        temp.setName(country.getName());
        temp.setEnable(country.getEnable());
         return dao.saveAndFlush(temp)!=null? 0:-1;
    }
    public int deleteCountry(Country country){
        int var=-1;
        Country temp=dao.findOne(country.getId());
        List<State> states=daos.findAll();
           /*for(int i=0; i<this.getAll().size(); i++){
            if (this.getAll().get(i).getCountry().equals(country)){
                temp.add(this.getAll().get(i));
            }
        }*/
       /* if(soa.findByCountry(country).isEmpty()){
            temp.setEnable(false);
            if (dao.saveAndFlush(temp)!=null)
                var=0;
        }*/
       return var; 
    }
 
}
