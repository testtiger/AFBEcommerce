package afbeans.repository.products;

import afbeans.model.products.Sku;
import afbeans.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/***

 Created by 
 @author dkammara on Friday - 11/22/2019

 /***
 Hibernate:
 create table sku (id varchar(255) not null,
 available_quantity bigint not null,
 description varchar(255),
 name varchar(255),
 price decimal(19,2),
 repository_id bigint, primary key (id))
 */
@Repository
//"insert into Product (name , repository_id  , description, product_type_product_type_id)  values( ?,?,?,?)";
public class SkusRepository implements GenericRepository<Sku> {

    JdbcTemplate template;

    public static String SQL_FOR_CREATE_SKU="insert into sku(id ,available_quantity ,name, description, price,repository_id)  values( ?,?,?,?,?,?) ";

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Sku findOne(long id) {
        return null;
    }

    @Override
    public List<Sku> findAll() {
        return null;
    }

    @Override
    public void create(Sku sku) {
        this.template.update(SQL_FOR_CREATE_SKU,sku.getId(),sku.getAvailableQuantity(),sku.getName(),sku.getDescription(),sku.getPrice(),sku.getProduct().getRepositoryId());
    }

    @Override
    public Sku update(Sku entity) {
        return null;
    }

    @Override
    public void delete(Sku entity) {

    }

    @Override
    public void deleteById(long entityId) {

    }
}
