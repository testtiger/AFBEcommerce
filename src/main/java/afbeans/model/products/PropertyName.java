package afbeans.model.products;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//create table property_name (property_name_id bigint not null, name varchar(255), primary key (property_name_id))

@Entity
public class PropertyName implements Serializable {

    String name;
    @Id
    long propertyNameId;



    @Transient
    List<PropertyValue> propertyValues;

    @ManyToOne
    @JoinColumn(name="productTypeId")
    public ProductType productType;

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getName() {
        return name;
    }
    public List<PropertyValue> getValues() {
        return propertyValues;
    }

    public void setValues(List<PropertyValue> propertyValues) {
        this.propertyValues = propertyValues;
    }

    @Override
    public String toString() {
        return "PropertyName{" +
                "name='" + name + '\'' +
                ", productTypeId=" + propertyNameId +
                ", values=" + propertyValues +
                '}';
    }

    public PropertyName(){

    }

    PropertyName(String name,long id){
        this.setName(name);
        this.setId(id);
    }
    PropertyName(String name){
        this.setName(name);
    }
    PropertyName(long id){
        this.setId(id);
    }

    public void setName(String name){
        this.name=name;
    }

    public long getId() {
        return propertyNameId;
    }


    public void setId(long id) {
        this.propertyNameId = id;
    }

}
