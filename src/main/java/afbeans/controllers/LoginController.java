package afbeans.controllers;

import afbeans.model.profiles.ShopperProfile;
import afbeans.services.ProfileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***

 Created by 
 @author dkammara on Monday - 10/21/2019

 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    ProfileServices profileServices;


    public void login(String inputEmail,String inputPassword){
        List<ShopperProfile> shoppers=profileServices.getProfiles();
        final ShopperProfile matchedProfile=null;
        shoppers.stream().filter((currentProfile)->{
            return currentProfile.getEmail().equals(inputEmail) && currentProfile.getPassword().equals(inputPassword) ;

        });
    }

}

