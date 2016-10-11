package navspringboot.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import navspringboot.models.Data;
import navspringboot.models.DataCrud;
import navspringboot.models.DataRepository;
import navspringboot.models.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @Value("${application.message}")
    private String message;
    @GetMapping("/")
    //@RequestMapping("/")
    //@RequestParam("filterobjecttype") String objecttype;
    //@RequestParam("filterobjectid") long objectid;

    public String index(Map<String, Object> model) {
        try {
            ArrayList<Row> rows = getRows("TableData",32,32); // 9

            model.put("message", this.message);
            model.put("rowscount", dataCrud.count());
            model.put("rows", rows);
        }
        catch (Exception ex) {
            return "Data not found";
        }

        return "index";
    }


    public ArrayList<Row> getRows(String objecttype, long objectid, long objectid2) {
        ArrayList<Row> Rows = new ArrayList<Row>();
        List<Data> data =
                dataRepository.findByObjecttypeAndRangefromLessThanEqualAndRangetoGreaterThanEqual(objecttype,objectid,objectid2);
        for (int i = 0; i < data.size(); i++) {
            Row row = new Row(
            String.valueOf(data.get(i).getObjecttype()),
            String.valueOf(data.get(i).getModulename()),
            String.valueOf(data.get(i).getVersionname()),
            String.valueOf(data.get(i).getRead()),
            String.valueOf(data.get(i).getInsert()),
            String.valueOf(data.get(i).getModify()),
            String.valueOf(data.get(i).getDelete()),
            String.valueOf(data.get(i).getExecute()),
            String.valueOf(data.get(i).getProductline())
            );

            Rows.add(row);
        }

        return Rows;
    }

    @Autowired
    private DataCrud dataCrud;

    @Autowired
    private DataRepository dataRepository;




}
