package afbeans.model.products;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

// create table property_value (productTypeId bigint not null, value varchar(255), property_name_id bigint, primary key (productTypeId))
//alter table property_value add constraint FKmq2b9e2s5u0pirv3smu68i497 foreign key (property_name_id) references property_name
@Entity
public class PropertyValue implements Serializable {

    String value;
    @Id
    long id;

    @ManyToOne
    @JoinColumn(name="propertyNameId")
    PropertyName propertyName;

    public PropertyValue(){
    }



    public PropertyValue(String value){
        this.setValue(value);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PropertyName getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(PropertyName propertyName) {
        this.propertyName = propertyName;
    }

    @Override
    public String toString() {
        return "PropertyValue{" +
                "value=" + value +
                ", productTypeId=" + id +
                '}';

    }


}
