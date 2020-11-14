package root.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
    return "index";
    }
    @RequestMapping(value = "/yourwarehouse",method = RequestMethod.GET)
    public String yourwarehouse(){
        return "yourwarehouse";
    }
    @RequestMapping(value = "/instruction",method = RequestMethod.GET)
    public String instruction(){
        return "instruction";
    }
    @RequestMapping(value = "/user/{id}/{id2}", method = RequestMethod.GET)
    public String parameterMethod1(@PathVariable int id,
                                   @PathVariable int id2) {
        System.out.println(id);
        System.out.println(id2);
        return "kontakt";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String parameterMethod2(@RequestParam int id,
                                   @RequestParam int id2,
                                   @RequestParam("blablabla") String name) {
        System.out.println(id);
        System.out.println(id2);
        System.out.println(name);
        return "kontakt";
    }
}
