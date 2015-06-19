package com.gembro;

import javafx.scene.Parent;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/** http://kielczewski.eu/2014/12/spring-boot-security-application/
 * @author quocanh
 *
 */

@Configuration
@EnableAutoConfiguration //This annotation tells Spring Boot to “guess” how you will want to configure Spring, based on the jar dependencies that you have added. 
@ComponentScan //@ComponentScan to find your beans, in combination with @Autowired constructor injection works well.  (@Component, @Service, @Repository, @Controller etc.) will be automatically registered as Spring Beans.
// @SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application implements ExitCodeGenerator{
	public static void main(String[] args) {
		SpringApplicationBuilder app = new SpringApplicationBuilder()
										.showBanner(false)
										.sources(Parent.class)
										.child(Application.class); // We need to pass DemoApplication.class as an argument to the run method to tell SpringApplication which is the primary Spring component.
        ApplicationContext ctx = app.run(args); 
		
		/*        
        System.out.println("Let's inspect the beans provided by Spring Boot:");
        
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        } 
        */ 
	}

	@Override
	public int getExitCode() {
		System.out.println("Finished");
		return 0;
	}
}