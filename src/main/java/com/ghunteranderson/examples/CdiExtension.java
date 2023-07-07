package com.ghunteranderson.examples;

import java.lang.annotation.Annotation;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.Readiness;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.spi.AfterBeanDiscovery;
import jakarta.enterprise.inject.spi.Extension;


@ApplicationScoped
public class CdiExtension implements Extension {

  public void afterBeanDiscovery(@Observes AfterBeanDiscovery event){
    // @Observes AfterBeanDiscovery event
    event.addBean()
      .types(HealthCheck.class)
      .qualifiers(new ReadinessAnnotation())
      .scope(ApplicationScoped.class)
      .produceWith(obj -> {
        return new GenericHealthCheck("Synthetic Health Check");
      });
  }

  public static class ReadinessAnnotation implements Readiness {
    @Override
    public Class<? extends Annotation> annotationType() {
      return Readiness.class;
    }
  }

}
