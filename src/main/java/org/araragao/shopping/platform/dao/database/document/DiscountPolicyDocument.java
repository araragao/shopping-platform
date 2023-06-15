package org.araragao.shopping.platform.dao.database.document;

import java.math.BigDecimal;
import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.araragao.shopping.platform.model.DiscountType;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "discount_policies")
public class DiscountPolicyDocument extends AuditableDocument {
  @MongoId
  private String id;
  @Indexed
  private String productId;
  private DiscountType type;
  @Indexed
  private Boolean active;
  private BigInteger threshold;
  private BigDecimal value;
}
