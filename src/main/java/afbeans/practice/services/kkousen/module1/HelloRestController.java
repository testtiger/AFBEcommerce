package afbeans.practice.services.kkousen.module1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
/***

 Created by 
 @author dkammara on Saturday - 9/7/2019

 */
@RestController
public class HelloRestController {

    @GetMapping("/hello")
    public Greeting sayHello(@RequestParam(required=false,defaultValue="world !")String message){
        String.format("");
        return new Greeting(message);
    }

}

class Greeting{

    private String message;

    public String getMessage(){
        return  message;
    }
    public void setMessage(String message){
        this.message=message;
    }
    public Greeting(String message){
        this.message=message;
    }

}