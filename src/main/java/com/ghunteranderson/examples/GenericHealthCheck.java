package com.ghunteranderson.examples;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

public class GenericHealthCheck implements HealthCheck {

  private String name;

  public GenericHealthCheck(String name) {
    this.name = name;
  }

  @Override
  public HealthCheckResponse call() {
    return HealthCheckResponse.up(name);
  }
}
