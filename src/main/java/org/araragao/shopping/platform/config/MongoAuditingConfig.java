package org.araragao.shopping.platform.config;

import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
@EnableMongoAuditing
public class MongoAuditingConfig {

  @Bean
  public AuditorAware<String> auditorProvider() {
    return new AuditorAwareImpl();
  }

  public static class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
      return Optional.of("default");
      // https://github.com/araragao/shopping-platform/issues/20
      // return Optional.ofNullable(SecurityContextHolder.getContext())
      //    .map(SecurityContext::getAuthentication)
      //    .filter(Authentication::isAuthenticated)
      //    .map(Authentication::getName);
    }
  }
}
