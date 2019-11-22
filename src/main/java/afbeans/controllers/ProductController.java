package afbeans.controllers;

import afbeans.model.products.Product;
import afbeans.repository.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/***

 Created by 
 @author dkammara on Thursday - 11/14/2019

 */
@RestController
@RequestMapping("/products")
public class ProductController extends GenericRestController {

    ProductRepository productRepository;


    public ProductRepository getProductRepository() {
        return productRepository;
    }
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public ResponseEntity<Void> addProduct(@RequestBody Product product){
        productRepository.create(product);

        return new ResponseEntity<Void>(getDefaultResponseHeaders(), HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id){
        return null;
    }
}
