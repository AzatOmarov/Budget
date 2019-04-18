package de.budget.project.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,
        ElementType.METHOD,
        ElementType.TYPE})
@Constraint(validatedBy = IsLongNotNullImpl.class)
public @interface IsLongNotNull {
    String message() default "the type of value should be Long!";
    Class<?>[] groups () default {};
    Class<? extends Payload> [] payload() default {};
}
