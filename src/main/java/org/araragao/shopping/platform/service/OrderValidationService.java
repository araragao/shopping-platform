package org.araragao.shopping.platform.service;

import java.math.BigInteger;
import lombok.extern.slf4j.Slf4j;
import org.araragao.shopping.platform.exception.custom.OrderValidationException;
import org.araragao.shopping.platform.model.Product;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderValidationService {

  /**
   Validates the order by checking the order's amount and stock availability of the product.
   If the product is out of stock or the order amount exceeds the product stock,
   an exception is thrown.
   @param amount the amount of the product to be ordered (as a BigInteger)
   @param product the product to be validated
   @throws OrderValidationException if the product is out of stock or the order amount exceeds the product stock
   */
  public void validate(BigInteger amount, Product product) {
    if (isProductOutOfStock(product.getStock())) {
      log.warn("Order Validation :: ProductId: {} is out of stock", product.getId());
      throw new OrderValidationException(
          "Product with id: " + product.getId() + " is out of stock");
    }

    if (isOrderAmountHigherThanProductStock(amount, product.getStock())) {
      log.warn(
          "Order Validation :: Order amount is higher than product stock :: "
              + "ProductId: {} ::: Product stock: {} ::: Order amount: {}",
          product.getId(),
          product.getStock(),
          amount);
      throw new OrderValidationException(
          "Product with id: "
              + product.getId()
              + " has lower stock than order's amount: "
              + amount);
    }
  }

  private boolean isProductOutOfStock(BigInteger stock) {
    return stock.compareTo(BigInteger.ZERO) == 0;
  }

  private boolean isOrderAmountHigherThanProductStock(BigInteger amount, BigInteger stock) {
    return amount.compareTo(stock) > 0;
  }
}
