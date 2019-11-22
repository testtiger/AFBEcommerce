package afbeans.repository.products;

import afbeans.model.products.ProductType;
import afbeans.model.products.PropertyName;
import afbeans.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/***

 Created by 
 @author dkammara on Wednesday - 11/6/2019
 product_type (id bigint not null, description varchar(255), name varchar(255), primary key (id))
 */
@Repository
public class ProductTypesRepository implements GenericRepository<ProductType> {

    final static String SQL_FOR_Product_Type_creation="insert into product_type (product_type_id , description , name)  values( ?,?,?) ";
    final static String SQL_FOR_GET_Product_Types="select * from  product_type";
    @Autowired
    JdbcTemplate template;

    @Autowired
    PropertyNameRepository propertyNameRepository;

    @Override
    public ProductType findOne(long id) {
        return null;
    }

    @Override
    public List<ProductType> findAll() {
        //this.template.query(sql,new AddressRepository.AddressRowMapper());
        return this.template.query(SQL_FOR_GET_Product_Types,new ProductTypesRepository.ProductTypeRowMapper());
    }

    @Override
    public void create(ProductType productType) {

        this.template.update(SQL_FOR_Product_Type_creation, productType.getProductTypeId(),productType.getDescription(),productType.getName());

        if(productType.getPropertyNames()!=null && !productType.getPropertyNames().isEmpty()){
            for(PropertyName propertyName: productType.getPropertyNames()){
                propertyName.setProductType(productType);
                propertyNameRepository.create(propertyName);
            }
        }

    }

    @Override
    public ProductType update(ProductType entity) {
        return null;
    }

    @Override
    public void delete(ProductType entity) {

    }

    @Override
    public void deleteById(long entityId) {

    }

    static class ProductTypeRowMapper implements RowMapper<ProductType>{

        @Override
        public ProductType mapRow(ResultSet resultSet, int i) throws SQLException {
            ProductType productType=new ProductType();
            productType.setDescription(resultSet.getString("description"));
            productType.setName(resultSet.getString("name"));
            productType.setProductTypeId(resultSet.getLong("product_type_id"));
            return productType;
        }
    }
}


