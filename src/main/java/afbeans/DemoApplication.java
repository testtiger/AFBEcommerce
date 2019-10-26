package afbeans;

import afbeans.practice.config.AppConfiguration;
import afbeans.practice.config.DummyAppConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//mvn spring-boot:run

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		/*//s
		ApplicationContext context=new AnnotationConfigApplicationContext(DummyAppConfiguration.class);
		CategoryService categoryService=context.getBean(CategoryService.class);
		System.out.println(categoryService.getAllCategories());
*/

	}

	public static void main1(){
		//my app configuration
		/*//s
		ApplicationContext context=new AnnotationConfigApplicationContext(DummyAppConfiguration.class);
		CategoryService categoryService=context.getBean(CategoryService.class);
		System.out.println(categoryService.getAllCategories());
*/
	}
}
