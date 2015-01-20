package sw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import sw.model.Model;
import sw.model.Suburb;
import sw.persistence.DaoModel;

@Service
public class ModelServices {

  @Autowired
  private DaoModel dao;
  
   public  Model getByName(String name){
       return dao.getByName(name); 
    }
    public List<Model>getAll(){
        return dao.findAll();
    }
    public List<Model>getBySuburb(int ID_Suburb){
        Suburb suburb=new Suburb();
        suburb.setId(ID_Suburb);
        return dao.getBySuburb(suburb);
    }
    public Model getOne (int id){
        return dao.findOne(id);
    }
    public int addModel (Model model){
      
        Model model_=new Model();
        model_.setName(model.getName());
        model_.setSuburb(model.getSuburb());
        model_.setLongitude(model.getLongitude());
        model_.setLatitude(model.getLatitude());
        model_.setEnable(model.getEnable());
        model_.setDescription(model.getDescription());
        return dao.saveAndFlush(model_)!=null? 0:-1;
    }
    public int updateModel(Model model){
       
        Model temp=dao.findOne(model.getId());
        temp.setId(model.getId()); // No creo que esto vaya... 
        temp.setName(model.getName());
        temp.setSuburb(model.getSuburb());
        temp.setLongitude(model.getLongitude());
        temp.setLatitude(model.getLatitude());
        temp.setEnable(model.getEnable());
        temp.setDescription(model.getDescription());
         return dao.saveAndFlush(temp)!=null? 0:-1;
    }
    public int deleteModel (Model model){
      Model temp=dao.findOne(model.getId());
      temp.setEnable(false);
      return dao.saveAndFlush(temp)!=null? 0:-1;
    }
}
