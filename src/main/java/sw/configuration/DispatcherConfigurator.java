package sw.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author jairsh
 */
@Configuration
@ComponentScan(basePackages = {"sw.controller", "sw.services", "sw.persistence"})
@EnableWebMvc
public class DispatcherConfigurator extends WebMvcConfigurerAdapter {
    
}
