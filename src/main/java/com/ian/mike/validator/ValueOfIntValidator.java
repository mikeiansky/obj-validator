package com.ian.mike.validator;

import com.ian.mike.validator.constraints.ValueOfInt;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;


public class ValueOfIntValidator implements ConstraintValidator<ValueOfInt, Integer> {

    private int[] allowedValues;

    @Override
    public void initialize(ValueOfInt annotation) {
        allowedValues = annotation.valueList();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        // 如果值为 null，则不做进一步验证，交由其他注解（如 @NotNull）处理
        if (value == null) {
            return true;
        }
        // 验证值是否在允许的列表中
        return Arrays.stream(allowedValues).anyMatch(allowedValue -> allowedValue == value);
    }

}