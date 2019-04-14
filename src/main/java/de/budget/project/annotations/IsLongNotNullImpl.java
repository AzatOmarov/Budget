package de.budget.project.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsLongNotNullImpl implements ConstraintValidator<IsLongNotNull, Long> {

   public void initialize(IsLongNotNull constraint) {
   }

   public boolean isValid(Long obj, ConstraintValidatorContext context) {
      if(obj != null && (obj instanceof Long)){
         return true;
      }
      return false;
   }

}
