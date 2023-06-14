package org.araragao.shopping.platform.model;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Page<T> {

  private List<T> content;
  private PageInfo pageInfo;
  private List<SortInfo> sortInfo;

  public Page(org.springframework.data.domain.Page<T> page) {
    this.content = page.getContent();
    this.pageInfo = buildPageInto(page);
    this.sortInfo = buildSortInfo(page);
  }

  private PageInfo buildPageInto(org.springframework.data.domain.Page<T> page) {
    return PageInfo.builder()
        .first(page.isFirst())
        .last(page.isLast())
        .totalPages(page.getTotalPages())
        .totalElements(page.getTotalElements())
        .numberOfElements(page.getNumberOfElements())
        .size(page.getSize())
        .number(page.getNumber())
        .build();
  }

  private List<SortInfo> buildSortInfo(org.springframework.data.domain.Page<T> page) {
    return page.getSort().stream()
        .map(
            order ->
                SortInfo.builder()
                    .property(order.getProperty())
                    .direction(order.getDirection().name())
                    .build())
        .toList();
  }

  @Getter
  @Builder
  public static class PageInfo {
    private Boolean first;
    private Boolean last;
    private Integer totalPages;
    private Long totalElements;
    private Integer numberOfElements;
    private Integer size;
    private Integer number;
  }

  @Getter
  @Builder
  public static class SortInfo {
    private String property;
    private String direction;
  }
}
