package org.araragao.shopping.platform.dao.database.init;

import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.araragao.shopping.platform.dao.database.document.DiscountPolicyDocument;
import org.araragao.shopping.platform.model.DiscountType;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeUnit(id = "DiscountPoliciesCollectionInit", order = "002", author = "araragao")
@RequiredArgsConstructor
public class DiscountPoliciesCollectionInit {

  private final MongoTemplate mongoTemplate;

  @Execution
  public void migration() {
    getDiscountPolicyDocuments()
        .forEach(
            discountPolicyDocument ->
                mongoTemplate.save(discountPolicyDocument, "discount_policies"));
  }

  @RollbackExecution
  public void rollbackMigration() {
    getDiscountPolicyDocuments()
        .forEach(
            discountPolicyDocument ->
                mongoTemplate.remove(discountPolicyDocument, "discount_policies"));
  }

  List<DiscountPolicyDocument> getDiscountPolicyDocuments() {
    DiscountPolicyDocument trousersActiveCountDiscountPolicy = new DiscountPolicyDocument();
    trousersActiveCountDiscountPolicy.setProductId("648b4168ca84014e814b3f7b");
    trousersActiveCountDiscountPolicy.setType(DiscountType.COUNT);
    trousersActiveCountDiscountPolicy.setActive(true);
    trousersActiveCountDiscountPolicy.setThreshold(BigInteger.TEN);
    trousersActiveCountDiscountPolicy.setValue(BigDecimal.ONE);
    trousersActiveCountDiscountPolicy.setCreatedBy("init");
    trousersActiveCountDiscountPolicy.setCreatedAt(LocalDateTime.now());

    DiscountPolicyDocument trousersInactiveCountDiscountPolicy = new DiscountPolicyDocument();
    trousersInactiveCountDiscountPolicy.setProductId("648b4168ca84014e814b3f7b");
    trousersInactiveCountDiscountPolicy.setType(DiscountType.COUNT);
    trousersInactiveCountDiscountPolicy.setActive(false);
    trousersInactiveCountDiscountPolicy.setThreshold(BigInteger.TEN);
    trousersInactiveCountDiscountPolicy.setValue(BigDecimal.valueOf(2));
    trousersInactiveCountDiscountPolicy.setCreatedBy("init");
    trousersInactiveCountDiscountPolicy.setCreatedAt(LocalDateTime.now());

    DiscountPolicyDocument trousersActivePercentageDiscountPolicy = new DiscountPolicyDocument();
    trousersActivePercentageDiscountPolicy.setProductId("648b4168ca84014e814b3f7b");
    trousersActivePercentageDiscountPolicy.setType(DiscountType.PERCENTAGE);
    trousersActivePercentageDiscountPolicy.setActive(true);
    trousersActivePercentageDiscountPolicy.setThreshold(BigInteger.ZERO);
    trousersActivePercentageDiscountPolicy.setValue(BigDecimal.valueOf(0.15));
    trousersActivePercentageDiscountPolicy.setCreatedBy("init");
    trousersActivePercentageDiscountPolicy.setCreatedAt(LocalDateTime.now());

    DiscountPolicyDocument perfumeActiveCountDiscountPolicy = new DiscountPolicyDocument();
    perfumeActiveCountDiscountPolicy.setProductId("648b4168ca84014e814b3f7c");
    perfumeActiveCountDiscountPolicy.setType(DiscountType.COUNT);
    perfumeActiveCountDiscountPolicy.setActive(true);
    perfumeActiveCountDiscountPolicy.setThreshold(BigInteger.valueOf(5));
    perfumeActiveCountDiscountPolicy.setValue(BigDecimal.ONE);
    perfumeActiveCountDiscountPolicy.setCreatedBy("init");
    perfumeActiveCountDiscountPolicy.setCreatedAt(LocalDateTime.now());

    DiscountPolicyDocument perfumeActivePercentageDiscountPolicy = new DiscountPolicyDocument();
    perfumeActivePercentageDiscountPolicy.setProductId("648b4168ca84014e814b3f7c");
    perfumeActivePercentageDiscountPolicy.setType(DiscountType.PERCENTAGE);
    perfumeActivePercentageDiscountPolicy.setActive(true);
    perfumeActivePercentageDiscountPolicy.setThreshold(BigInteger.ZERO);
    perfumeActivePercentageDiscountPolicy.setValue(BigDecimal.valueOf(0.05));
    perfumeActivePercentageDiscountPolicy.setCreatedBy("init");
    perfumeActivePercentageDiscountPolicy.setCreatedAt(LocalDateTime.now());

    return List.of(
        trousersActiveCountDiscountPolicy,
        trousersInactiveCountDiscountPolicy,
        trousersActivePercentageDiscountPolicy,
        perfumeActiveCountDiscountPolicy,
        perfumeActivePercentageDiscountPolicy);
  }
}
