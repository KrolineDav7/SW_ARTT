package sw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import sw.model.Country;
import sw.services.CountryServices;

@Controller
@RequestMapping(value="/country")
public class CountryController 
{
  @Autowired
    CountryServices soacountry;
  
  @RequestMapping(value = "/one/{id}", method=RequestMethod.GET)
    public @ResponseBody Country getOne(@PathVariable("id") Integer id){
        return soacountry.getOne(id);
    }
  
  @RequestMapping(value = "/all", method=RequestMethod.GET)
    public @ResponseBody List<Country> getAll()
    {
        return soacountry.getAll();
    }
}
