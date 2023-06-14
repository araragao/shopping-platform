package org.araragao.shopping.platform.exception;

import org.araragao.shopping.platform.exception.custom.DiscountPolicyNotFoundException;
import org.araragao.shopping.platform.exception.custom.OrderValidationException;
import org.araragao.shopping.platform.exception.custom.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {ProductNotFoundException.class, DiscountPolicyNotFoundException.class})
  public ResponseEntity<Object> handleNotFoundExceptions(RuntimeException ex) {
    ErrorResponse errorResponse = new ErrorResponseException(HttpStatus.NOT_FOUND, ex);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
  }

  @ExceptionHandler(OrderValidationException.class)
  public ResponseEntity<Object> handleOrderValidationException(RuntimeException ex) {
    ErrorResponse errorResponse = new ErrorResponseException(HttpStatus.BAD_REQUEST, ex);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
  }
}
