package sw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import sw.model.Pais;
import sw.services.PaisServices;

@Controller
@RequestMapping(value="/modelo")
public class PaisController 
{
  @Autowired
    PaisServices soapais;
  
  @RequestMapping(value = "/uno/{id}", method=RequestMethod.GET)
    public @ResponseBody Pais getOne(@PathVariable("id") Integer id){
        return soapais.getOne(id);
    }
  
  @RequestMapping(value = "/todos", method=RequestMethod.GET)
    public @ResponseBody List<Pais> getAll()
    {
        return soapais.getAll();
    }
}
