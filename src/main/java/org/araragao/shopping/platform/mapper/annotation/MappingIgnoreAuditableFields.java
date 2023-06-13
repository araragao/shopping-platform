package org.araragao.shopping.platform.mapper.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.mapstruct.Mapping;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
@Mapping(target = "createdBy", ignore = true)
@Mapping(target = "createdAt", ignore = true)
@Mapping(target = "lastModifiedBy", ignore = true)
@Mapping(target = "lastModifiedAt", ignore = true)
public @interface MappingIgnoreAuditableFields {

}
