package afbeans.practice.config;

import afbeans.practice.services.categories.CategoryService;
import afbeans.practice.services.categories.DummyCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/***

 Created by 
 @author dkammara on Tuesday - 7/23/2019

 */
@Configuration
@PropertySource("classpath:AppPreferences.properties")
public class DummyAppConfiguration {



    @Value("#{new Boolean('${workWithDummyData}')}")
    private boolean isWorkWithDummyData;
    @Bean
    public CategoryService categoryService(){
        System.out.println("-------->"+isWorkWithDummyData);
        return new DummyCategoryServiceImpl();
    }

}
