package afbeans.model.products;

import afbeans.model.categories.Category;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/***

 Created by 
 @author dkammara on Monday - 7/22/2019

 */
@Entity
public class Product implements Serializable {

    private String name;

    @Id
    private long repositoryId;
    private String description;

    @Transient
    private List<Sku> skuList;

    @OneToOne(targetEntity = ProductType.class)
    private ProductType productType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(long id) {
        this.repositoryId = id;
    }

    public List<Sku> getSkuList() {
        return skuList;
    }


    public void setSkuList(List<Sku> skuList) {
        this.skuList = skuList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    /*public Category getCategoryRef() {
        return categoryRef;
    }

    public void setCategoryRef(Category categoryRef) {
        this.categoryRef = categoryRef;
    }*/

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", productTypeId=" + repositoryId +
                ", description='" + description + '\'' +
                ", skuList=" + skuList +
                ", productType=" + productType +
                '}';
    }

    public static void unitTest(){

    }
    public static void getData(){

    }
    public static void main(String[] args) {

    }
}
