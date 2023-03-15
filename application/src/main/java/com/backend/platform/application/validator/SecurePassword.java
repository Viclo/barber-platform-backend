package com.backend.platform.application.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = SecurePassword.PasswordValidator.class)
public @interface SecurePassword {

  String message() default
      """
          # A digit must occur at least once
          # A lower case letter must occur at least once
          # An upper case letter must occur at least once
          # A special character must occur at least once (one of !@#$%^&*(),.?":{}|<>)\s
          # No whitespace allowed in the entire string
          # At least eight places""";

  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};

  @Component
  class PasswordValidator implements ConstraintValidator<SecurePassword, String> {

    private static final String DEFAULT_PASSWORD_REQUIREMENTS = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*(),.?\":{}|<>])(?=\\S+$).{8,}$";

    @Value("${password.format:" + DEFAULT_PASSWORD_REQUIREMENTS + "}")
    private String pwFormat;

    @Override
    public boolean isValid(String text, ConstraintValidatorContext constraintValidatorContext) {
      return text != null && text.matches(pwFormat);
    }
  }
}
