package afbeans.practice.restresources;

import afbeans.model.profiles.ShopperProfile;
import afbeans.practice.services.profiles.ShopperProfileServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/***

 Created by 
 @author dkammara on Friday - 7/5/2019

 */
@RestController

public class ProfileResource {

    ShopperProfileServiceImpl profile;

    /*@RequestMapping(method=RequestMethod.GET,value = "/profiles/{id}")
    public GenericProfile<T> getProfile(@PathVariable String id){
        ShopperProfile t=new ShopperProfile("test","last","test@gmail.com","12345","122113");
        return t;
    }*/
    @RequestMapping(method=RequestMethod.GET,value = "/profiles1/{id}")
    public ShopperProfile getProfile(@PathVariable String id){
        ShopperProfile t=new ShopperProfile("test","last","test@gmail.com","12345","122113");
        return t;
    }
}
