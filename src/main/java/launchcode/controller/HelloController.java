package launchcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Controller
public class HelloController {



    @RequestMapping(value = "/main-page", method = RequestMethod.GET)
    @ResponseBody
    public String hello(){

        return "<form action=\"/add\" method=\"get\">\n" +
                "    <label>First Number</label><input type=\"number\" id=\"username\" name=\"username\"> \n" +
                "    <label>Second Number</label><input type=\"number\" id=\"email\" name=\"email\">\n" +
                "    <button>Send</button>\n" +
                "</form>";

    }

    @GetMapping(path="/add")
    public @ResponseBody Integer addUser(@RequestParam String username, @RequestParam String email) {
        int fNum = Integer.parseInt(username);
        int sNum = Integer.parseInt(email);
        return fNum + sNum;
    }

    @GetMapping("/{searchPhrase}")
    @ResponseBody
    @ResponseStatus(OK)
    public String findItemsByCategory(@PathVariable("searchPhrase") String searchPhrase) {

        System.out.println(searchPhrase);
        return searchPhrase.toUpperCase();
    }
}
