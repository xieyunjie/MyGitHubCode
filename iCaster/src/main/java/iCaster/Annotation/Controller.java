package iCaster.Annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;

@Stereotype
@Target(
{ TYPE })
@Retention(RUNTIME)
@Documented
@Named
@RequestScoped
//@Interceptor
//@ControllerLogging
public @interface Controller
{
  
}
