package myFirstSpringBootApp.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUsernameValidator.class)
public @interface UniqueUsername {
    String message() default "{myFirstSpringBootApp.uniqueUsername.message}";
    Class<?> [] groups() default {};
    Class <? extends Payload>[] payload() default {};
}
