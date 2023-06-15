package org.araragao.shopping.platform.dao.database.init;

import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.araragao.shopping.platform.dao.database.document.ProductDocument;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeUnit(id = "ProductsCollectionInit", order = "001", author = "araragao")
@RequiredArgsConstructor
public class ProductsCollectionInit {

  private final MongoTemplate mongoTemplate;

  @Execution
  public void migration() {
    getProductDocuments()
        .forEach(productDocument -> mongoTemplate.save(productDocument, "products"));
  }

  @RollbackExecution
  public void rollbackMigration() {
    getProductDocuments()
        .forEach(productDocument -> mongoTemplate.remove(productDocument, "products"));
  }

  List<ProductDocument> getProductDocuments() {
    ProductDocument trousers = new ProductDocument();
    trousers.setId("648b4168ca84014e814b3f7b");
    trousers.setName("Levi's 501");
    trousers.setPrice(BigDecimal.valueOf(89.9));
    trousers.setStock(BigInteger.valueOf(150));
    trousers.setCreatedBy("init");
    trousers.setCreatedAt(LocalDateTime.now());

    ProductDocument perfume = new ProductDocument();
    perfume.setId("648b4168ca84014e814b3f7c");
    perfume.setName("Tom Ford - Black Orchid");
    perfume.setPrice(BigDecimal.valueOf(220.0));
    perfume.setStock(BigInteger.valueOf(30));
    perfume.setCreatedBy("init");
    perfume.setCreatedAt(LocalDateTime.now());

    return List.of(trousers, perfume);
  }
}
