package com.ghunteranderson.examples;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.Readiness;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class AnnotatedProducerHealthCheck {
  
  @Produces
  @ApplicationScoped
  @Readiness
  HealthCheck annotatedFieldHealthCheck = new GenericHealthCheck("Annotated Field Helath Check");

  @Produces
  @ApplicationScoped
  @Readiness
  HealthCheck annotatedMethodHealthCheck(){
    return new GenericHealthCheck("Annotated Method Health Check");
  }
}
