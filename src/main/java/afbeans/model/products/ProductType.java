package afbeans.model.products;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/***

 Created by 
 @author dkammara on Monday - 7/22/2019

 */
//create table product_type (productTypeId bigint not null, description varchar(255), name varchar(255), primary key (productTypeId))
@Entity
public class ProductType implements Serializable {

    @Id
    long productTypeId;
    String name;
    String description;

    @Transient
    List<PropertyName> propertyNames;

    public ProductType(){

    }

    public long getProductTypeId(){
        return productTypeId;
    }
    public void setProductTypeId(long productTypeId){
        this.productTypeId = productTypeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PropertyName> getPropertyNames() {
        return propertyNames;
    }

    public void setPropertyNames(List<PropertyName> propertyNames) {
        this.propertyNames = propertyNames;
    }


    public static List<ProductType> getDummyProductsTypesListForTest(){

        ProductType productType=new ProductType();
        ProductType productType2=new ProductType();

        /*PropertyPair<String,String> p1=new PropertyPair("size","uk9" ,10001);
        PropertyPair<String,String> p2=new PropertyPair("color","Blue",10002);
        PropertyPair<String,String> p3=new PropertyPair("memory","2gb",10003);
        PropertyPair<String,Integer> p4=new PropertyPair("memory",2,10003);
        PropertyPair<String,Integer> p5=new PropertyPair("memory",true,10003);*/
        PropertyName p1=new PropertyName("size",10001);
        PropertyName p2=new PropertyName("color",10002);
        PropertyName p3=new PropertyName("memory",10003);

        PropertyValue uk9=new PropertyValue("Uk9");
        PropertyValue uk8=new PropertyValue("US8");
        PropertyValue uk7=new PropertyValue("US7");

        PropertyValue memory=new PropertyValue("2GB");

        p1.setValues(Arrays.asList(uk9,uk7,uk8));
        p3.setValues(Arrays.asList(memory));

        productType.setName("shoe");
        productType.setDescription("this is shoe description");
        productType.setPropertyNames(Arrays.asList(p1,p2));


        productType2.setName("DVD");
        productType2.setDescription("this is DVD description");
        productType2.setPropertyNames(Arrays.asList(p3));

        return  Arrays.asList(productType,productType2);
    }
    public static void main(String[] args) {
        for(ProductType productType:getDummyProductsTypesListForTest()){
            System.out.println(productType);
        }
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", propertyNames=" + propertyNames +
                '}';
    }


}

/*

@Entity
class PropertyPair<T1,T2>{

    T1 name;
    T2 value;
    @Id
    long productTypeId;

    PropertyPair(){

    }

    PropertyPair(T1 name,T2 value){
        this.setName(name);
        this.setValue(value);
    }
    PropertyPair(T1 name,T2 value, long productTypeId){
        this.setName(name);
        this.setValue(value);
        this.setProductTypeId(productTypeId);
    }

    @Override
    public String toString() {
        return "PropertyPair{" +
                "name=" + name +
                ", value=" + value +
                ", productTypeId=" + productTypeId +
                '}';
    }

    public void setName(T1 name){
        this.name=name;
    }

    public long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public void setValue(T2 value) {
        this.value = value;
    }
}*/
