
package afbeans.practice.services.kkousen.module1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/***

 Created by 
 @author dkammara on Wednesday - 8/28/2019

 */

@Controller
public class HelloWorldController {

    public HelloWorldController(){
        System.out.println("HelloWorldController ---------->instantiated");
    }

    @RequestMapping(method=RequestMethod.GET,value = "/profiles1234")
    public String helloWorld(@RequestAttribute(required=false,value="world") String greet){
        return "index";
    }

    @GetMapping("/12ty")
    public String main(@RequestParam(required = false,defaultValue="world")String message, Model model) {
        message="Hello, "+message+" !!";
        model.addAttribute("message", message);
        return "index"; //view
    }

}

