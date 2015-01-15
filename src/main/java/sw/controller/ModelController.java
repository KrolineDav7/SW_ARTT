package sw.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
  @RequestMapping(value = "/agregar", method=RequestMethod.POST)
    public @ResponseBody Modelo addPost(@RequestParam(required=true) String nombre,@RequestParam(required=true) String desc,@RequestParam(required=true) boolean disp,@RequestParam(required=true) String colonia)
    {
      Modelo temp = new Modelo();
        temp.setNombre(nombre);
      temp.setDescripcion(desc);
      temp.setDisponible(disp);
      //Despues agregar el objeto colonia partiendo de un id
      temp.setColonia(null);
      return soamodelo.agregarModelo(temp);
    }
  @RequestMapping(value = "/editar", method=RequestMethod.POST)
    public @ResponseBody Modelo editarPost(@RequestParam(required=true) Integer id,@RequestParam(required=true) String nombre,@RequestParam(required=true) String desc,@RequestParam(required=true) boolean disp,@RequestParam(required=true) String colonia)
    {
        Modelo temp = new Modelo();
          temp.setNombre(nombre);
        temp.setDescripcion(desc);
        temp.setDisponible(disp);
        //Despues agregar el objeto colonia partiendo de un id
        temp.setColonia(null);
        return soamodelo.actualizarModelo(temp);
    }
}
