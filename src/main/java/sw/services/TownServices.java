/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sw.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sw.model.State;
import sw.model.Town;
import sw.persistence.DaoTown;

/**
 *
 * @author Carolina
 */
@Service 
public class TownServices {
    @Autowired
    private DaoTown dao;
    
    public Town getByName (String name){
       return dao.getByName(name); 
    }
    public List<Town>getAll(){
        return dao.findAll();
    }
    public Town getOne (int id){
        return dao.findOne(id);
    }
  
    public int addTown (Town town){
      
        Town town_=new Town();
        town_.setName(town.getName());
        town_.setEnable(town.getEnable());
        town_.setState(town.getState());
        return dao.saveAndFlush(town_)!=null? 0:-1;
    }
    public int updateTown(Town town){
       
        Town temp=dao.findOne(town.getId());
        temp.setId(town.getId());
        temp.setName(town.getName());
        temp.setState(town.getState());
        temp.setEnable(town.getEnable());
         return dao.saveAndFlush(temp)!=null? 0:-1;
    }
    public List<Town> getTownByState(State state){
        List<Town> temp=new ArrayList();
        List<Town> all=dao.findAll();
        for(int i=0; i<all.size(); i++){
            if (all.get(i).getState().equals(state)){
                temp.add(all.get(i));
            }
        }
        return temp;
    }
}
