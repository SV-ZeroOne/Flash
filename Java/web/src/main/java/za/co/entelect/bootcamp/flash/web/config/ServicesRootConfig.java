package za.co.entelect.bootcamp.flash.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */

@Configuration
@EnableGlobalMethodSecurity
@ImportResource("classpath:services-configuration.xml")
public class ServicesRootConfig {
}
