package afbeans.repository.products;

import afbeans.model.products.PropertyName;
import afbeans.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PropertyNameRepository implements GenericRepository<PropertyName> {

    final static String SQL_FOR_Property_Name_creation="insert into property_name (property_name_id , name, product_type_id)  values( ?,?,?) ";
    final static String SQL_FOR_GET_Property_Name="select * from  product_type";

    @Autowired
    JdbcTemplate template;

    @Override
    public PropertyName findOne(long id) {
        return null;
    }

    @Override
    public List<PropertyName> findAll() {
        return null;
    }

    @Override
    public void create(PropertyName entity) {
        this.template.update(SQL_FOR_Property_Name_creation,entity.getId(),entity.getName(),entity.getProductType().getProductTypeId());
    }

    @Override
    public PropertyName update(PropertyName entity) {
        return null;
    }

    @Override
    public void delete(PropertyName entity) {

    }

    @Override
    public void deleteById(long entityId) {

    }
}
