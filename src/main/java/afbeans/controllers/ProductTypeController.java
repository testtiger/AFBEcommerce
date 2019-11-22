package afbeans.controllers;

import afbeans.model.products.ProductType;
import afbeans.model.products.PropertyName;
import afbeans.model.products.PropertyValue;
import afbeans.repository.products.ProductTypesRepository;
import afbeans.repository.products.PropertyNameRepository;
import afbeans.repository.products.PropertyValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***

 Created by 
 @author dkammara on Wednesday - 11/6/2019

 */
@RestController
@RequestMapping("/productTypes")
public class ProductTypeController {


    private ProductTypesRepository productTypesRepository;
    private PropertyNameRepository propertyNameRepository;
    private PropertyValueRepository propertyValueRepository;

    public PropertyValueRepository getPropertyValueRepository() {
        return propertyValueRepository;
    }

    @Autowired
    public void setPropertyValueRepository(PropertyValueRepository propertyValueRepository) {
        this.propertyValueRepository = propertyValueRepository;
    }

    @Autowired
    public void setProductTypesRepository(ProductTypesRepository productTypesRepository) {
        this.productTypesRepository = productTypesRepository;
    }
    public ProductTypesRepository getProductTypesRepository() {
        return productTypesRepository;
    }

    @Autowired
    public void setPropertyNameRepository(PropertyNameRepository propertyNameRepository) {
        this.propertyNameRepository = propertyNameRepository;
    }

    public PropertyNameRepository getPropertyNameRepository() {
        return propertyNameRepository;
    }

    @GetMapping
    public List<ProductType> getAllProductTypes(){
        return productTypesRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> createProductType(@RequestBody ProductType productType){
        productTypesRepository.create(productType);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    @PostMapping("{id}/propertyNames")
    public ResponseEntity<Void> createPropertyName(@PathVariable long id,@RequestBody PropertyName propertyName){
        ProductType ptype=new ProductType();
        ptype.setProductTypeId(id);
        propertyName.setProductType(ptype);

        propertyNameRepository.create(propertyName);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @PostMapping("{id}/propertyNames/{propId}/propertyValue")
    public ResponseEntity<Void> createPropertyValue(@PathVariable long id, @PathVariable long propId,@RequestBody PropertyValue propertyValue){
        ProductType ptype=new ProductType();
        ptype.setProductTypeId(id);
        PropertyName pname=new PropertyName();
        pname.setId(propId);
        propertyValue.setPropertyName(pname);
        propertyValueRepository.create(propertyValue);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
