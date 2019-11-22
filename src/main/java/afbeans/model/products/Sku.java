package afbeans.model.products;

import afbeans.model.categories.Category;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/***

 Created by 
 @author dkammara on Wednesday - 10/30/2019


 // sku belongs to product
 // can represnt concrete product detaisl as such  -

    name(String) | description(String)      |availble Quantity(String) | properties(size:color ...) :key value pairs| unit conversion|
    -------------------------------------------------------------------------------------------------------------
    1.) red-shoe         |A great runnig shoe |10 quantity | ( US9 - RED | US9- BLUE | US8 -GREEN) | 1|
    2.) PULSES -RICE    |SONA MASURI         |10 kg       | ( none) | 1000 grams
    3.) MEAT -CHICKEN  |RED MEAT           |10 kg       | ( none) | 1000 grams
    4.) MILK - LOOSE   | HERIATAGE MILK     |10 Liters   | ( none) | 1000 ml
    4.) MILK - packets   | HERIATAGE MILK packets     |10 packets   | ( none) | 1000 ml
 */
@Entity
public class Sku implements Serializable {

    @Id
    private String id;
    private String name;
    private String description;
    private long availableQuantity;
    private BigDecimal price;

    @JoinColumn(name = "repositoryId")
    @ManyToOne
    private Product product;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public long getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(long availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }




}
