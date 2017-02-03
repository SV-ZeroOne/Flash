package za.co.entelect.bootcamp.flash.web.errors;

import groovy.util.logging.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

/**
 * Created by byron.dinkelmann on 2017/02/03.
 */
@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class GlobalExceptionControllerAdvice {
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handle404() {
        //log.info("No handler found for URL {}.", request.getRequestURL());
        return new ModelAndView("forward:/404");
    }
    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ModelAndView handleAllExceptions(/*Exception ex, HttpServletRequest request*/) {
        //log.error(String.format("An unhandled error occurred on page %s.", request.getRequestURL()) ,ex);
        return new ModelAndView("redirect:/500");
    }
    /*@ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public String handleAccessDenied(AccessDeniedException ex) {
        return "forward:/accessDenied";
    }*/
}