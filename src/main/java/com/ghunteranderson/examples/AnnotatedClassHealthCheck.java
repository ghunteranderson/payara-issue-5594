package com.ghunteranderson.examples;

import org.eclipse.microprofile.health.Readiness;


import jakarta.enterprise.context.ApplicationScoped;

@Readiness
@ApplicationScoped
public class AnnotatedClassHealthCheck extends GenericHealthCheck {

  public AnnotatedClassHealthCheck(){
    super("Annotated Class Health Check");
  }
  
}
