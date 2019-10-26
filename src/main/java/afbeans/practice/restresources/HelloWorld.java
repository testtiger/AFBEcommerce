package afbeans.practice.restresources;

import org.springframework.web.bind.annotation.*;

/***

 Created by 
 @author dkammara on Sunday - 6/30/2019

 */
@RestController
@RestControllerAdvice
public class HelloWorld {

    @RequestMapping(method=RequestMethod.GET,value="/v1/hello/{id}")
    public String sayHello(@PathVariable String id){
        return "hello--"+id;
    }

    @RequestMapping(method=RequestMethod.GET,value="/v1/hello")
    public String sayHello(){
        return "hello123--";
    }


}
