package afbeans.repository.products;

import afbeans.model.products.PropertyValue;
import afbeans.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/***

 Created by 
 @author dkammara on Wednesday - 11/6/2019

 */
@Repository
public class PropertyValueRepository implements GenericRepository<PropertyValue> {
    final static String SQL_FOR_Property_Value_creation="insert into property_value (id , value, property_name_id)  values( ?,?,?) ";

    JdbcTemplate jdbcTemplate;


    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    public PropertyValue findOne(long id) {
        return null;
    }

    @Override
    public List<PropertyValue> findAll() {
        return null;
    }

    @Override
    public void create(PropertyValue entity) {
        jdbcTemplate.update(SQL_FOR_Property_Value_creation,entity.getId(),entity.getValue(),entity.getPropertyName().getId());
        //create table property_value (id bigint not null, value varchar(255), property_name_id bigint, primary key (id))
    }

    @Override
    public PropertyValue update(PropertyValue entity) {
        return null;
    }

    @Override
    public void delete(PropertyValue entity) {

    }

    @Override
    public void deleteById(long entityId) {

    }
}
