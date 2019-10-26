package afbeans.controllers;

import afbeans.model.profiles.GenericProfile;
import afbeans.model.profiles.ShopperProfile;
import afbeans.services.ProfileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

import java.util.List;

import static afbeans.PrintUtil.println;

/***

 Created by 
 @author dkammara on Monday - 9/9/2019

 */

/***
 * TODO : ADD OFFSET AND LIMIT CONTROL FOR ENDPOINT CLASS
 * TODO : ADD VALIDATION LOGIC FOR REQUEST PAYLOAD
 * TODO : BATCH UPDATES SUPPORT FOR MULTIPLE ADDRESSES
 */
@RestController
@RequestMapping(value = "profiles")
public class ProfileController {

    @Autowired
    ProfileServices profileServices;

    public ProfileController(){
        println("profile controller instantiated");
    }

    @GetMapping
    public ResponseEntity<List<GenericProfile>> getProfiles(){
        List<ShopperProfile> profiles=profileServices.getProfiles();
        return  new ResponseEntity(profiles,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addProfile( @Valid @RequestBody ShopperProfile profile){
        profileServices.addProfile(profile);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GenericProfile> getProfile(@PathVariable long id){
        GenericProfile profile=profileServices.getProfile(id);
        return new ResponseEntity<GenericProfile>(profile,HttpStatus.OK);
    }

}
