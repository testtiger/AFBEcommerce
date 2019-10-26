package afbeans.practice.config;

import afbeans.model.profiles.ShopperProfile;
import afbeans.practice.services.categories.CategoryService;
import afbeans.practice.services.categories.DummyCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/***
 Created by
 @author dkammara on Monday - 7/22/2019
 */
@Configuration
@PropertySource("classpath:AppPreferences.properties")
public class AppConfiguration {


    @Value("#{new Boolean('${workWithDummyData}')}")
    private String isWorkWithDummyData;
    /**
     * 1. When the application loads
     * 2. I will show categories/categories on the home page
     * 3. Hero slider header/footer will be displayed
     * 4. On login User will gets displayed
     *
     */

    /**
     *
     * @return
     */
    @Bean
    public ShopperProfile getProfile(){
        return null;
    }

    @Bean
    public CategoryService getCollectionService(){
        System.out.println("-------isWorkWithDummyData"+isWorkWithDummyData);
        if(isWorkWithDummyData.equals("true")){
            return new DummyCategoryServiceImpl();
        }
        return null;
    }
}


