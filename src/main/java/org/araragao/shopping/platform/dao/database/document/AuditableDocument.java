package org.araragao.shopping.platform.dao.database.document;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuditableDocument {
  @CreatedBy
  String createdBy;
  @CreatedDate
  LocalDateTime createdAt;
  @LastModifiedBy
  String lastModifiedBy;
  @LastModifiedDate
  LocalDateTime lastModifiedAt;
}
