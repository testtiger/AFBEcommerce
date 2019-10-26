package afbeans.practice.services;

import afbeans.model.categories.Category;

import java.util.Arrays;
import java.util.List;

/***

 Created by 
 @author dkammara on Monday - 7/22/2019

 */
public class UtilClassForDummies{

    public static List<Category> getDummyCollections(){

        Category milkCategory=new Category("Milk","Milk-123","Milk Description",null);
        Category vegetablesCategory=new Category("Veggies","Veg-123","Veggie Description",null);
        Category groceriesCategory=new Category("Groceries","Gro-123","Groceries Description",null);

        return Arrays.asList(milkCategory,vegetablesCategory,groceriesCategory);
    }
}