package afbeans.model.products;

import afbeans.model.categories.Category;

/***

 Created by 
 @author dkammara on Monday - 7/22/2019

 */
public class Product {
    private String name;
    private String id;
    private String description;
    private ProductType productType;
    private Category categoryRef;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategoryRef() {
        return categoryRef;
    }

    public void setCategoryRef(Category categoryRef) {
        this.categoryRef = categoryRef;
    }
    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
