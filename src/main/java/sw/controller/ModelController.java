package sw.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import sw.model.Model;
import sw.services.ModelServices;

@Controller
@RequestMapping(value="/model")
public class ModelController 
{
    @Autowired
    ModelServices soamodelo;
  
  
  @RequestMapping(value = "/all", method=RequestMethod.GET)
    public @ResponseBody List<Model> getAll()
    {
		 return soamodelo.getAll();
    }
  @RequestMapping(value ="/{id}")
  @ResponseBody
  public Model getOne( @PathVariable("id") int id)
  {
    return soamodelo.getOne(id);
  }
  @RequestMapping(value ="/suburb/{id}")
  @ResponseBody
  public List<Model> getBySuburb( @PathVariable("ID_Suburb") int ID_Suburb)
  {
    return soamodelo.getBySuburb(ID_Suburb);
  }
  @RequestMapping(value ="/name/{name}")
  @ResponseBody
  public Model obtenerXNombre( @PathVariable("name") String name)
  {
    return soamodelo.getByName(name);
  }
  @RequestMapping(value = "/add", method=RequestMethod.POST)
    public @ResponseBody int addPost(@RequestParam(required=true) String name,@RequestParam(required=true) String desc,@RequestParam(required=true) boolean enabled,@RequestParam(required=true) String town)
    {
      Model temp = new Model();
      temp.setName(name);
      temp.setDescription(desc);
      temp.setEnable(enabled);
      //Despues agregar el objeto colonia partiendo de un id
      //temp.setTown(null);
      return soamodelo.addModel(temp);
    }
  @RequestMapping(value = "/modify", method=RequestMethod.POST)
    public @ResponseBody int editarPost(@RequestParam(required=true) Integer id,@RequestParam(required=true) String name,@RequestParam(required=true) String desc,@RequestParam(required=true) boolean enabled,@RequestParam(required=true) String colonia)
    {
        Model temp = new Model();
        temp.setName(name);
        temp.setDescription(desc);
        temp.setEnable(enabled);
        //Despues agregar el objeto colonia partiendo de un id
        //temp.setTown(null);
        return soamodelo.updateModel(temp);
    }
}
