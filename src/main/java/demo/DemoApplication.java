package demo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration //This annotation tells Spring Boot to “guess” how you will want to configure Spring, based on the jar dependencies that you have added. 
public class DemoApplication {

	
    public static void main(String[] args) {
        
        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args); // We need to pass DemoApplication.class as an argument to the run method to tell SpringApplication which is the primary Spring component.

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        
        DemoHibernate.runHibernateDemo();

    }    
    

}
