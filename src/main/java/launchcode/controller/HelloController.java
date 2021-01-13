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
                "    <label>First Number</label><input type=\"number\" id=\"firstNum\" name=\"firstNum\"> \n" +
                "    <label>  </label><input type=\"text\" id=\"operator\" name=\"operator\"> \n" +

                "    <label>Second Number</label><input type=\"number\" id=\"SecondNum\" name=\"SecondNum\">\n" +
                "    <button>Calculate</button>\n" +
                "</form>";

    }

    @GetMapping(path="/add")
    public @ResponseBody String addUser(@RequestParam String firstNum, @RequestParam String SecondNum, @RequestParam String operator) {
        int fNum = Integer.parseInt(firstNum);
        int sNum = Integer.parseInt(SecondNum);

        if(operator.equals("+")){
            return "Result: " + String.valueOf(fNum + sNum);
        }else if(operator.equals("-")){
            return "Result: " + String.valueOf(fNum - sNum);

        }else if(operator.equals("*")){
            return "Result: " + String.valueOf(fNum * sNum);
        }else if(operator.equals("/")){
            return "Result: " + String.valueOf(fNum / sNum);
        }else{
            return "Wrong input!";
        }
    }

    @GetMapping("/{searchPhrase}")
    @ResponseBody
    @ResponseStatus(OK)
    public String findItemsByCategory(@PathVariable("searchPhrase") String searchPhrase) {

        System.out.println(searchPhrase);
        return searchPhrase.toUpperCase();
    }
}
