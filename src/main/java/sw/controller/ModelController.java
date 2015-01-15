package sw.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import sw.model.Modelo;

@Controller
@RequestMapping(value="/modelo")
public class ModelController 
{
//  @Autowired
    //ModeloServices soamodelo;
  
  
  @RequestMapping(value = "/todos", method=RequestMethod.GET)
    public @ResponseBody List<Modelo> getAll()
    {
//        return soamodelo.obtenerTodos();
    		return null;
    }
}
