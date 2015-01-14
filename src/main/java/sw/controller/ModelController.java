package sw.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping(value="/modelo")
public class ModelController 
{
  @Autowired
    ModeloServices soamodelo;
}
