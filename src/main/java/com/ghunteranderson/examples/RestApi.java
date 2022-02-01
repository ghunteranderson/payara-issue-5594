package com.ghunteranderson.examples;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.Readiness;


@Path("/health-checks")
@ApplicationScoped
public class RestApi {

  @Inject
  @Readiness
  private Instance<HealthCheck> readinessChecks;

  /**
   * This endpoint lets us inspect all HealthCheck CDI beans with @Readiness qualifier
   * @return names of all readiness checks
   */
  @GET
  @Path("readiness")
  public List<String> healthChecks(){
    return readinessChecks
      .stream()
      .map(h -> h.call().getName())
      .collect(Collectors.toList());
  }
}
