package sw.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import sw.model.State;
import sw.persistence.DaoState;

@Service
public class StateServices {
  
   @Autowired 
   private DaoState dao;
    
    /*public Estado obtenerNombre(String nombre){
       return dao.obtenerNombre(nombre); 
    }*/
    public List<State>getAll(){
        return dao.findAll();
    }
    public State getState(int id){
        return dao.findOne(id);
    }
  
    public int addState (State state){
      
        State state_=new State();
        state_.setName(state.getName());
        state_.setCountry(state.getCountry());
        state_.setEnable(state.getEnable());
        return dao.saveAndFlush(state_)!=null? 0:-1;
    }
    public int updateState(State state){
       
        State temp=dao.findOne(state.getId());
        temp.setId(state.getId());
        temp.setName(state.getName());
        temp.setCountry(state.getCountry());
        temp.setEnable(state.getEnable());
         return dao.saveAndFlush(temp)!=null? 0:-1;
    }
 
}
