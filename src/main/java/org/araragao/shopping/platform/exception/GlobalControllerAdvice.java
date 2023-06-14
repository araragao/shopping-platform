package org.araragao.shopping.platform.exception;

import java.util.HashMap;
import java.util.Map;
import org.araragao.shopping.platform.exception.custom.DiscountPolicyNotFoundException;
import org.araragao.shopping.platform.exception.custom.OrderValidationException;
import org.araragao.shopping.platform.exception.custom.ProductNotFoundException;
import org.araragao.shopping.platform.util.StringFormatterUtil;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

  @ExceptionHandler(value = {ProductNotFoundException.class, DiscountPolicyNotFoundException.class})
  public ErrorResponse handleNotFoundExceptions(RuntimeException ex) {
    return ErrorResponse.create(ex, HttpStatus.NOT_FOUND, ex.getMessage());
  }

  @ExceptionHandler(OrderValidationException.class)
  public ErrorResponse handleOrderValidationException(OrderValidationException ex) {
    return ErrorResponse.create(ex, HttpStatus.BAD_REQUEST, ex.getMessage());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    Map<String, String> argumentValidationErrors = new HashMap<>();

    ex.getBindingResult()
        .getAllErrors()
        .forEach(
            (error) -> {
              String fieldName = ((FieldError) error).getField();
              String errorMessage = error.getDefaultMessage();
              argumentValidationErrors.put(fieldName, errorMessage);
            });

    return ErrorResponse.create(
        ex, HttpStatus.BAD_REQUEST, StringFormatterUtil.formatMap(argumentValidationErrors));
  }
}
