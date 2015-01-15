package sw.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import sw.model.Modelo;
import sw.services.ModeloServices;

@Controller
@RequestMapping(value="/modelo")
public class ModelController 
{
    @Autowired
    ModeloServices soamodelo;
  
  
  @RequestMapping(value = "/todos", method=RequestMethod.GET)
    public @ResponseBody List<Modelo> getAll()
    {
		 return soamodelo.obtenerTodos();
    }
  
  @RequestMapping(value ="/modelo/{id}")
  @ResponseBody
  public Modelo obtenerUno( @PathVariable("id") int id)
  {
    return soamodelo.obtenerUno(id);
  }
  @RequestMapping(value ="/modelo/nombre/{nombre}")
  @ResponseBody
  public Modelo obtenerXNombre( @PathVariable("nombre") String nombre)
  {
    return soamodelo.obtenerXNombre(nombre);
  }
}
