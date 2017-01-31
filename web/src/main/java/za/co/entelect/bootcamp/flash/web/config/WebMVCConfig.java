package za.co.entelect.bootcamp.flash.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */

@Configuration
@ComponentScan(basePackages = "za.co.entelect.bootcamp.flash.web.controllers")
public class WebMVCConfig {

}
