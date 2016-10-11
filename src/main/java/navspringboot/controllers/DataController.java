package navspringboot.controllers;

import navspringboot.models.Data;
import navspringboot.models.DataCrud;
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
    String ret_objecttype;
    String ret_description;
    String ret_rangefrom;
    String ret_rangeto;
    String ret_read;
    String ret_insert;
    String ret_modify;
    String ret_delete;
    String ret_execute;
    String ret_productline;
    String ret_moduleid;
    String ret_versionname;
    String ret_moduleid2;

    try {
      Data data = dataCrud.findOne(dataid);

      ret_dataid = String.valueOf(data.getDataid());
      ret_modulename = String.valueOf(data.getModulename());
      ret_objecttype = String.valueOf(data.getObjecttype());
      ret_description = String.valueOf(data.getDescription());
      ret_rangefrom = String.valueOf(data.getRangefrom());
      ret_rangeto = String.valueOf(data.getRangeto());
      ret_read = String.valueOf(data.getRead());
      ret_insert = String.valueOf(data.getInsert());
      ret_modify = String.valueOf(data.getModify());
      ret_delete = String.valueOf(data.getDelete());
      ret_execute = String.valueOf(data.getExecute());
      ret_productline = String.valueOf(data.getProductline());
      ret_moduleid = String.valueOf(data.getModuleid());
      ret_versionname = String.valueOf(data.getVersionname());
      ret_moduleid2 = String.valueOf(data.getModuleid2());

    }
    catch (Exception ex) {
      return "Data not found";
    }
    return
    "data id: " + ret_dataid + " ; " +
    "module name: " + ret_modulename + " ; " +
    "objecttype: " + ret_objecttype + " ; " +
    "description: "+ ret_description + " ; " +
    "rangefrom: "+ ret_rangefrom + " ; " +
    "rangeto: "+ ret_rangeto + " ; " +
    "read: "+ ret_read + " ; " +
    "insert: "+ ret_insert + " ; " +
    "modify: "+ ret_modify + " ; " +
    "delete: "+ ret_delete + " ; " +
    "execute: "+ ret_execute + " ; " +
    "productline: "+ ret_productline + " ; " +
    "moduleid: "+ ret_moduleid + " ; " +
    "versionname: "+ ret_versionname + " ; " +
    "moduleid2: "+ ret_moduleid2;
  }
  

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  @Autowired
  private DataCrud dataCrud;
  
} // class DataController
