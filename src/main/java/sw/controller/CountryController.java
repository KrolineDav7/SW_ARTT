package sw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import sw.model.Country;
import sw.services.CountryServices;

@Controller
@RequestMapping(value="/country")
public class CountryController 
{
    @Autowired
    CountryServices soacountry;
    
  @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    public @ResponseBody Country getOne(@PathVariable("id") Integer id){
        return soacountry.getOne(id);
    }
  
  @RequestMapping(value = "/all", method=RequestMethod.GET)
    public @ResponseBody List<Country> getAll()
    {
        return soacountry.getAll();
    }
  @RequestMapping(value = "/add", method=RequestMethod.POST)
    public @ResponseBody int addNewCountry(@RequestParam(required=true) String name){
        Country temp = new Country();
        temp.setName(name);
        temp.setEnable(true);
        return soacountry.addPais(temp);
    }
  @RequestMapping(value="/delete", method=RequestMethod.POST)
   public @ResponseBody int deleteCountry(@RequestParam(required=true) int id){
       Country temp =new Country();
       temp.setId(id);
       return soacountry.deleteCountry(temp);
    }
}
