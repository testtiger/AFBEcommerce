package afbeans.practice.services.categories;

import afbeans.model.categories.Category;
import afbeans.practice.services.UtilClassForDummies;

import java.util.List;

/***

 Created by 
 @author dkammara on Monday - 7/22/2019

 */
public class DummyCategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> getAllCategories() {
        return UtilClassForDummies.getDummyCollections();
    }
}
