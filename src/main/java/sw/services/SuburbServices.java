package sw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import sw.model.Suburb;
import sw.persistence.DaoSuburb;

/* Servicio disponibes para una colonia*/
@Service
public class SuburbServices {

  @Autowired 
  private DaoSuburb dao;
  
   public Suburb getByName(String name){
       return dao.getByName(name); 
    }
    public List<Suburb>getAll(){
        return dao.findAll();
    }
    public Suburb getOne (int id){
        return dao.findOne(id);
    }
  
    public int addSuburb (Suburb suburb){
      
        Suburb suburb_=new Suburb();
        suburb_.setName(suburb.getName());
        suburb_.setTown(suburb.getTown());
        suburb_.setEnable(suburb.getEnabled());
        return dao.saveAndFlush(suburb_)!=null? 0:-1;
    }
    public int updateSuburb(Suburb suburb){
       
        Suburb temp=dao.findOne(suburb.getId());
        temp.setId(suburb.getId());
        temp.setName(suburb.getName());
        temp.setTown(suburb.getTown());
        temp.setEnable(suburb.getEnabled());
         return dao.saveAndFlush(temp)!=null? 0:-1;
    }
}
