package afbeans.controllers;

import afbeans.model.products.Sku;
import afbeans.repository.products.SkusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/***

 Created by 
 @author dkammara on Friday - 11/22/2019

 */
@Controller
@RequestMapping("/skus")
public class SkuController extends GenericRestController {


    SkusRepository skusRepository;

    public SkusRepository getSkusRepository() {
        return skusRepository;
    }

    @Autowired
    public void setSkusRepository(SkusRepository skusRepository) {
        this.skusRepository = skusRepository;
    }

    @PostMapping
    public ResponseEntity<Void> createSku(@RequestBody Sku sku){
        skusRepository.create(sku);
        HttpHeaders headers=getDefaultResponseHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


}
