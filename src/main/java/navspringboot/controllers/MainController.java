package navspringboot.controllers;

import java.util.*;

import navspringboot.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class MainController {

    @Value("${application.message}")
    private String message;

    @RequestMapping("/")

    public String index(
                        Map<String, Object> model,
                        HttpServletRequest request,
                        HttpServletResponse response)
    {
        Filter filter = new Filter();
        ArrayList<String> types = new ArrayList<String>();
        types.add("TableData");
        types.add("TableDescription");
        types.add("Form");
        types.add("Report");
        types.add("Dataport");
        types.add("XMLport");
        types.add("Codeunit");
        types.add("MenuSuite");
        types.add("Page");

        try {
            if (request.getParameter("Clear") == null) {

                filter.setFilterobjecttype(request.getParameter("filterobjecttype"));
                try {
                    filter.setFilterobjectid(Long.parseLong(request.getParameter("filterobjectid")));
                } catch (NumberFormatException e) {
                    filter.setFilterobjectid(-1l);
                }

                ArrayList<Row> rows = getRows(filter.getFilterobjecttype(), filter.getFilterobjectid(), filter.getFilterobjectid());

                model.put("message", this.message);
                model.put("rowscount", dataCrud.count());
                model.put("types", types);
                model.put("filter",filter);
                model.put("rows", rows);


            } else {

                filter.setFilterobjecttype("TableDate");
                filter.setFilterobjectid(-1l);
                model.put("message", this.message);
                model.put("rowscount", dataCrud.count());
                model.put("types", types);
                model.put("filter",filter);
                model.put("rows", null);

            }

        }
        catch (Exception ex) {
            return "Data not found";
        }
        return "index";
    }

    public ArrayList<Row> getRows(String objecttype, Long objectid, Long objectid2) {
        ArrayList<Row> Rows = new ArrayList<Row>();
        List<Data> data =
                dataRepository.findByObjecttypeAndRangefromLessThanEqualAndRangetoGreaterThanEqualOrderByModulenameAscProductlineAscVersionnameAscDataidAsc
                                (objecttype,objectid,objectid2); // order by ModulenameAscProductlineAscVersionnameAscDataidAsc
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

        } // for

        return Rows;
    }

    @Autowired
    private DataCrud dataCrud;

    @Autowired
    private DataRepository dataRepository;

} // class MainController
