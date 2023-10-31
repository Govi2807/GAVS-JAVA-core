package MVCwebDemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableMvc;
 
 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"MVCwebdemo"})
public class SpringConfiguration{
 
}