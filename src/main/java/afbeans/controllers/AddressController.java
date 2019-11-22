package afbeans.controllers;

import afbeans.model.address.Address;
import afbeans.repository.addresses.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***

 Created by 
 @author dkammara on Tuesday - 10/22/2019

 */
@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @PostMapping
    public ResponseEntity<Void> addAddress(@RequestBody Address address){
        addressRepository.create(address);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress(){
        List<Address> addressList=addressRepository.findAll();
        return new ResponseEntity(addressList,HttpStatus.OK);
    }
}
