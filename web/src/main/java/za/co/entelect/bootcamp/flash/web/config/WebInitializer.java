package za.co.entelect.bootcamp.flash.web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {WebSecurityConfig.class, ServicesRootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebMVCConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
