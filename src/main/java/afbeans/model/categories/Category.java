package afbeans.model.categories;

/***

 Created by 
 @author dkammara on Monday - 7/22/2019

 */
public class Category {

    String name;
    String id;
    String description;
    Category subCategoryRef;

    public Category(String name, String id, String description, Category subCategoryRef) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.subCategoryRef = subCategoryRef;
    }

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

    public Category getSubCategoryRef() {
        return subCategoryRef;
    }

    public void setSubCategoryRef(Category subCategoryRef) {
        this.subCategoryRef = subCategoryRef;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", subCategoryRef=" + subCategoryRef +
                '}';
    }

}
