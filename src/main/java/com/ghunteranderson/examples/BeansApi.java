package com.ghunteranderson.examples;

import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse.Status;
import org.eclipse.microprofile.health.Readiness;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;


@ApplicationScoped
@Path("beans")
public class BeansApi {

  @Inject
  @Readiness
  private Instance<HealthCheck> healthChecks;

  /**
   * This endpoint lets us inspect all HealthCheck CDI beans
   * @return names of all readiness checks
   */
  @GET
  @Path("health-checks")
  public Map<String, Status> healthChecks(){
    return healthChecks
      .stream()
      .map(h -> h.call())
      .collect(Collectors.toMap(result -> result.getName(), result -> result.getStatus()));
  }
}
