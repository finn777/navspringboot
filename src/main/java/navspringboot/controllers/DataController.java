package navspringboot.controllers;

import navspringboot.models.Data;
import navspringboot.models.DataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataController {

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  @RequestMapping("/get-by-data-id")
  @ResponseBody

  // http://localhost:7777/get-by-data-id?dataid=7
  public String getByobjecttypeobjectid(long dataid) {
    String ret_dataid;
    String ret_modulename;
    try {
      Data data = dataDao.findOne(dataid);
      ret_dataid = String.valueOf(data.getDataid());
      ret_modulename = String.valueOf(data.getModulename());
    }
    catch (Exception ex) {
      return "Data not found";
    }
    return "data id: " + ret_dataid +" ; "+
           "module name : '" + ret_modulename+"'";
  }
  

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  @Autowired
  private DataDao dataDao;
  
} // class DataController
