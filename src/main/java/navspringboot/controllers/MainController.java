package navspringboot.controllers;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @GetMapping("/")

    public String index(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        model.put("rowscount", 250);
        return "index";
    }


}
