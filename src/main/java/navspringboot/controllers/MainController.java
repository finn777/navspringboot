package navspringboot.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import navspringboot.models.Data;
import navspringboot.models.DataCrud;
import navspringboot.models.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @GetMapping("/")

    public String index(Map<String, Object> model) {
        try {
            List<Data> ret_data = getRows("TableData",32);
            model.put("time", new Date());
            model.put("message", this.message);
            model.put("rowscount", dataCrud.count());
            model.put("querycount", ret_data.size());
        }
        catch (Exception ex) {
            return "Data not found";
        }

        return "index";
    }


    public List<Data> getRows(String objecttype, long rangefrom) {
        List<Data> data = dataRepository.findByObjecttypeAndRangefrom(objecttype, rangefrom);
        return data;
    }

    @Autowired
    private DataCrud dataCrud;

    @Autowired
    private DataRepository dataRepository;




}
