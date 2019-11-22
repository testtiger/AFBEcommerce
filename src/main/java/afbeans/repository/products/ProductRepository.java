package afbeans.repository.products;

import afbeans.model.products.Product;
import afbeans.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/***

 Created by 
 @author dkammara on Thursday - 11/14/2019

 */
@Repository
public class ProductRepository implements GenericRepository<Product> {

    private final String SQL_FOR_CREATE_PRODUCT="insert into Product (name , repository_id  , description, product_type_product_type_id)  values( ?,?,?,?)";
    private JdbcTemplate template;


    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }



    @Override
    public Product findOne(long id) {

        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void create(Product product) {
        this.template.update(SQL_FOR_CREATE_PRODUCT,product.getName(),product.getRepositoryId(),product.getDescription(),product.getProductType().getProductTypeId());
    }

    @Override
    public Product update(Product entity) {
        return null;
    }

    @Override
    public void delete(Product entity) {

    }

    @Override
    public void deleteById(long entityId) {

    }
}
